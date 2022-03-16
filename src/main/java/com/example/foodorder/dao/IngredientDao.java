package com.example.foodorder.dao;

import java.util.List;

import com.example.foodorder.entity.Ingredient;

public interface IngredientDao {

	public List<Ingredient> findAll();
	public Ingredient save(Ingredient entity);
	public Ingredient update(Ingredient entity);
	public Ingredient delete(String uid);
	public Ingredient find(String uid);
	
}
