package com.example.foodorder.bll;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodorder.dao.IngredientDao;
import com.example.foodorder.entity.Ingredient;
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
	public Ingredient add(String uid, int qty) {
		Ingredient entity = ingredientDao.find(uid);
		int currQty = entity.getQty();
		currQty+= qty;
		entity.setQty(currQty);
		return entity;
	}

}
