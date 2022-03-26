package com.example.foodorder.bll;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodorder.dao.IngredientDao;
import com.example.foodorder.dao.IngredientLogDao;
import com.example.foodorder.entity.Ingredient;
import com.example.foodorder.entity.Ingredient4ConsumeBO;
import com.example.foodorder.entity.Ingredient4ConsumeBO.ConsumeType;
import com.example.foodorder.entity.Ingredient4RestockBO;
import com.example.foodorder.entity.IngredientLog;
import com.example.foodorder.util.UUIDHelper;

@Service
public class IngredientServiceImpl implements IngredientService {

	@Autowired
	private IngredientDao ingredientDao;

	@Autowired
	private IngredientLogDao ingredientLogDao;

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
	public Ingredient restock(Ingredient4RestockBO bo, String batchno) {
		Ingredient entity = ingredientDao.find(bo.getUid());
		int currQty = entity.getQty();
		currQty += bo.getQty();
		entity.setQty(currQty);

		IngredientLog mainLog = new IngredientLog(bo.getComment(), bo.getUid(), batchno);
		mainLog.setAction("Restock");
		mainLog.setQuantity(bo.getQty());
		ingredientLogDao.save(mainLog);

		return entity;
	}

	@Transactional
	@Override
	public Ingredient consume(Ingredient4ConsumeBO bo, String batchno) throws Exception {

		// consume ingredient
		Ingredient entity4consume = ingredientDao.find(bo.getUid());
		int currQty = entity4consume.getQty();
		currQty -= bo.getQty();

		IngredientLog mainLog = new IngredientLog(bo.getComment(), bo.getUid(), batchno);

		if (currQty < 0) {
			throw new RuntimeException(entity4consume.getName() + "數量不足");
		} else {
			entity4consume.setQty(currQty);
			mainLog.setQuantity(0 - bo.getQty());

			if (bo.getAction() == ConsumeType.Packaged) {
				mainLog.setAction("Packaged");

				// find the ingredient which is packaged to and then restock the ingredient's
				// quantity
				List<Ingredient> entity4packagedList = ingredientDao.findPackageIngredient(bo.getUid());
				if (entity4packagedList.size() > 0) {
					Ingredient entity4packaged = entity4packagedList.get(0);
					int totalPackagedQty = bo.getQty() * bo.getPackagedQty();
					int entity4packagedTotalQty = entity4packaged.getQty() + totalPackagedQty;
					entity4packaged.setQty(entity4packagedTotalQty);

					IngredientLog cascadeLog = new IngredientLog("cascade: " + bo.getComment(),
							entity4packaged.getUid(), batchno);
					cascadeLog.setAction("Packaged");
					cascadeLog.setQuantity(totalPackagedQty);
					ingredientLogDao.save(cascadeLog);
				} else {
					System.err.println("找不到分裝食材");
				}
			} else if (bo.getAction() == ConsumeType.Expired) {
				mainLog.setAction("Expired");
			} else if (bo.getAction() == ConsumeType.Sold) {
				mainLog.setAction("Sold");
			}
			ingredientLogDao.save(mainLog);
		}

		return entity4consume;
	}

	@Override
	public List<Ingredient> findPackageList(String uid) {
		return ingredientDao.findPackageIngredient(uid);
	}

}
