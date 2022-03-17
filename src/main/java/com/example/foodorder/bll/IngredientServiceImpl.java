package com.example.foodorder.bll;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodorder.dao.IngredientDao;
import com.example.foodorder.entity.Ingredient;
import com.example.foodorder.entity.Ingredient4ConsumeBO;
import com.example.foodorder.entity.Ingredient4ConsumeBO.ConsumeType;
import com.example.foodorder.entity.Ingredient4RestockBO;
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
	public Ingredient restock(Ingredient4RestockBO bo) {		
		Ingredient entity = ingredientDao.find(bo.getUid());
		int currQty = entity.getQty();
		currQty += bo.getQty();
		entity.setQty(currQty);
		return entity;
	}

	@Transactional
	@Override
	public Ingredient consume(Ingredient4ConsumeBO bo) {
		Ingredient entity4consume = ingredientDao.find(bo.getUid());
		int currQty = entity4consume.getQty();
		currQty -= bo.getQty();
		entity4consume.setQty(currQty);
		
		if(bo.getAction() == ConsumeType.Packaged) {
			List<Ingredient> entity4packagedList = ingredientDao.findPackageIngredient(bo.getUid());
			if(entity4packagedList.size() > 0) {
				Ingredient entity4packaged = entity4packagedList.get(0);
				int totalPackagedQty = bo.getQty() * bo.getPackagedQty();
				int entity4packagedTotalQty = entity4packaged.getQty() + totalPackagedQty;
				entity4packaged.setQty(entity4packagedTotalQty);
			} else {
				System.err.println("找不到分裝食材");
			}
		}
		
		return entity4consume;
	}

	@Override
	public List<Ingredient> findPackageList(String uid) {
		return ingredientDao.findPackageIngredient(uid);
	}

}
