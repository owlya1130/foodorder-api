package com.example.foodorder.bll.ingredient;

import java.util.List;

import com.example.foodorder.entity.ingredient.Ingredient;
import com.example.foodorder.entity.ingredient.BOConsume;
import com.example.foodorder.entity.ingredient.BORestock;

public interface IngredientService {
	public List<Ingredient> findAll();
	public Ingredient save(Ingredient entity);
	public Ingredient update(Ingredient entity);
	public Ingredient delete(String uid);
	public Ingredient restock(BORestock bo, String batchno);
	public Ingredient consume(BOConsume bo, String batchno) throws Exception;
	public List<Ingredient> findPackageList(String uid);
}
