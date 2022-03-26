package com.example.foodorder.bll;

import java.util.List;

import com.example.foodorder.entity.Meal;

public interface MealService {
	public List<Meal> findAll();
	public Meal save(Meal entity);
	public Meal update(Meal entity);
	public Meal delete(String uid);
	public Meal find(String uid);
}
