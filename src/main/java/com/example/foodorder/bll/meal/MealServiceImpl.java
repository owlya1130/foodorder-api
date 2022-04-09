package com.example.foodorder.bll.meal;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodorder.dao.meal.MealDao;
import com.example.foodorder.entity.meal.Meal;
import com.example.foodorder.entity.meal.MealIngredient;
import com.example.foodorder.util.UUIDHelper;

@Service
public class MealServiceImpl implements MealService {

	@Autowired
	private MealDao mealDao;
	
	@Override
	public List<Meal> findAll() {
		return mealDao.findAll();
	}

	@Transactional
	@Override
	public Meal save(Meal entity) {
		String uid = UUIDHelper.getUUID();
		entity.setUid(uid);
		for(MealIngredient mealIngredient: entity.getMealIngredients()) {
			mealIngredient.getUid().setMealUid(uid);
		}
		return mealDao.save(entity);
	}

	@Transactional
	@Override
	public Meal update(Meal entity) {
		for(MealIngredient mealIngredient: entity.getMealIngredients()) {
			if(mealIngredient.getUid().getMealUid() == null) {
				mealIngredient.getUid().setMealUid(entity.getUid());
			}
		}
		return mealDao.update(entity);
	}

	@Transactional
	@Override
	public Meal delete(String uid) {
		return mealDao.delete(uid);
	}

	@Override
	public Meal find(String uid) {
		return  mealDao.find(uid);
	}

}
