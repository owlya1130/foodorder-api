package com.example.foodorder.dao.meal;

import java.util.List;

import com.example.foodorder.entity.meal.Meal;

public interface MealDao {

	public List<Meal> findAll();
	public Meal save(Meal entity);
	public Meal update(Meal entity);
	public Meal delete(String uid);
	public Meal find(String uid);
	
}
