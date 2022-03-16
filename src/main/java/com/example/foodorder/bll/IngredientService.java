package com.example.foodorder.bll;

import java.util.List;

import com.example.foodorder.entity.Ingredient;

public interface IngredientService {
	public List<Ingredient> findAll();
	public Ingredient save(Ingredient entity);
	public Ingredient update(Ingredient entity);
	public Ingredient delete(String uid);
	public Ingredient add(String uid, int qty);
}
