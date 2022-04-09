package com.example.foodorder.bll.ingredient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodorder.dao.ingredient.IngredientDao;
import com.example.foodorder.entity.ingredient.Ingredient;
import com.example.foodorder.entity.ingredient.IngredientActionType;
import com.example.foodorder.entity.ingredient.BOConsume;
import com.example.foodorder.entity.ingredient.BORestock;
import com.example.foodorder.entity.ingredient.IngredientLog;
import com.example.foodorder.entity.ingredient.IngredientQuantity;
import com.example.foodorder.util.UUIDHelper;

@Service
public class IngredientServiceImpl implements IngredientService {

	@Autowired
	private IngredientDao ingredientDao;

	@Override
	public List<Ingredient> findAll() {
		return ingredientDao.findAll();
	}

	@Transactional
	@Override
	public Ingredient save(Ingredient entity) {
		String uid = UUIDHelper.getUUID();
		entity.setUid(uid);
		return ingredientDao.save(entity);
	}

	@Transactional
	@Override
	public Ingredient update(Ingredient entity) {
		return ingredientDao.update(entity);
	}

	@Transactional
	@Override
	public Ingredient delete(String uid) {
		return ingredientDao.delete(uid);
	}

	@Transactional
	@Override
	public Ingredient restock(BORestock bo, String batchno) {
		Ingredient entity = ingredientDao.find(bo.getUid());

		IngredientQuantity quantity = new IngredientQuantity();
		quantity.setIngredientUid(entity.getUid());
		quantity.setQty(bo.getQty());
		quantity.setCost(bo.getCost());

		List<IngredientQuantity> quantities = entity.getQuantityDetails();
		if (quantities == null) {
			quantities = new ArrayList<>();
		}
		quantities.add(quantity);
		entity.setQuantityDetails(quantities);

		IngredientLog log = new IngredientLog();
		log.setAction(bo.getActionType());
		log.setQty(bo.getQty());
		log.setComment(bo.getComment());
		log.setTime(new Date());
		log.setBatchno(batchno);

		List<IngredientLog> logs = quantity.getLogs();
		if (logs == null) {
			logs = new ArrayList<>();
		}
		logs.add(log);
		quantity.setLogs(logs);

		ingredientDao.update(entity);
		return entity;
	}

	class IngredientQuantitySort implements Comparator<IngredientQuantity> {
		public int compare(IngredientQuantity a, IngredientQuantity b) {
			return (int) (a.getCreateTime().getTime() - b.getCreateTime().getTime());
		}
	}

	@Transactional
	@Override
	public Ingredient consume(BOConsume bo, String batchno) throws Exception {
		Ingredient entity = ingredientDao.find(bo.getUid());

		List<IngredientQuantity> quantities = entity.getQuantityDetails();
		Collections.sort(quantities, new IngredientQuantitySort());
		for (int i = 0; i < quantities.size(); i++) {
			if (bo.getQty() <= 0)
				break;

			IngredientQuantity quantity = quantities.get(i);
			int currQty = quantity.getQty();
			if (currQty == 0)
				continue;

			IngredientLog log = new IngredientLog();
			log.setAction(bo.getActionType());
			log.setComment(bo.getComment());
			log.setTime(new Date());
			log.setBatchno(batchno);

			int changeQty = 0;
			if (currQty >= bo.getQty()) {
				changeQty = bo.getQty();
				quantity.setQty(currQty - changeQty);
				log.setQty(changeQty);
				bo.setQty(0);
			} else {
				changeQty = currQty;
				quantity.setQty(0);
				log.setQty(changeQty);
				bo.setQty(bo.getQty() - changeQty);
			}
			List<IngredientLog> logs = quantity.getLogs();
			logs.add(log);
			quantity.setLogs(logs);

			if (bo.getActionType() == IngredientActionType.PackagedFrom) {
				List<Ingredient> targetEntityList = ingredientDao.findPackageIngredient(bo.getUid());
				if (targetEntityList.size() != 1) {
					throw new RuntimeException("分裝設定檔錯誤");
				}

				Ingredient targetEntity = targetEntityList.get(0);
				int restockQty = changeQty * bo.getPackagedQty();
				int restockCost = changeQty * quantity.getCost();
				BORestock boRestock = new BORestock();
				boRestock.setUid(targetEntity.getUid());
				boRestock.setActionType(IngredientActionType.PackagedTo);
				boRestock.setComment(bo.getComment());
				boRestock.setCost(restockCost/restockQty);
				boRestock.setQty(restockQty);
				restock(boRestock, batchno);
			}

		}

		if (bo.getQty() > 0) {
			throw new RuntimeException(entity.getName() + "數量不足");
		}
		
		ingredientDao.update(entity);
		return entity;

//
//		if (currQty < 0) {
//			
//		} else {
//			entity4consume.setQty(currQty);
//			mainLog.setQuantity(0 - bo.getQty());
//
//			if (bo.getAction() == ConsumeType.Packaged) {
//				mainLog.setAction("Packaged");
//
//				// find the ingredient which is packaged to and then restock the ingredient's
//				// quantity
//				List<Ingredient> entity4packagedList = ingredientDao.findPackageIngredient(bo.getUid());
//				if (entity4packagedList.size() > 0) {
//					Ingredient entity4packaged = entity4packagedList.get(0);
//					int totalPackagedQty = bo.getQty() * bo.getPackagedQty();
//					int entity4packagedTotalQty = entity4packaged.getQty() + totalPackagedQty;
//					entity4packaged.setQty(entity4packagedTotalQty);
//
//					IngredientLog cascadeLog = new IngredientLog("cascade: " + bo.getComment(),
//							entity4packaged.getUid(), batchno);
//					cascadeLog.setAction("Packaged");
//					cascadeLog.setQuantity(totalPackagedQty);
//					ingredientLogDao.save(cascadeLog);
//				} else {
//					System.err.println("找不到分裝食材");
//				}
//			} else if (bo.getAction() == ConsumeType.Expired) {
//				mainLog.setAction("Expired");
//			} else if (bo.getAction() == ConsumeType.Sold) {
//				mainLog.setAction("Sold");
//			}
//			ingredientLogDao.save(mainLog);
//		}
//
//		return entity4consume;
//		return null;
	}

	@Override
	public List<Ingredient> findPackageList(String uid) {
		return ingredientDao.findPackageIngredient(uid);
	}

}
