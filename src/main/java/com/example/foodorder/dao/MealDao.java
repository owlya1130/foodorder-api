package com.example.foodorder.dao;

import java.util.List;

import com.example.foodorder.entity.Meal;

public interface MealDao {

	public List<Meal> findAll();
	public Meal save(Meal entity);
	public Meal update(Meal entity);
	public Meal delete(String uid);
	
}
