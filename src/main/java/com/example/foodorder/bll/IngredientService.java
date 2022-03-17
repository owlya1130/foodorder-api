package com.example.foodorder.bll;

import java.util.List;

import com.example.foodorder.entity.Ingredient;
import com.example.foodorder.entity.Ingredient4ConsumeBO;
import com.example.foodorder.entity.Ingredient4RestockBO;

public interface IngredientService {
	public List<Ingredient> findAll();
	public Ingredient save(Ingredient entity);
	public Ingredient update(Ingredient entity);
	public Ingredient delete(String uid);
	public Ingredient restock(Ingredient4RestockBO bo);
	public Ingredient consume(Ingredient4ConsumeBO bo);
	public List<Ingredient> findPackageList(String uid);
}
