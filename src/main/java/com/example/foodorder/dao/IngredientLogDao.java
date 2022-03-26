package com.example.foodorder.dao;

import java.util.List;

import com.example.foodorder.entity.IngredientLog;

public interface IngredientLogDao {

	public List<IngredientLog> findAll(String ingredientUid);
	public IngredientLog save(IngredientLog entity);
	
}
