package com.example.foodorder.api.ingredient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodorder.bll.ingredient.IngredientService;
import com.example.foodorder.entity.ingredient.Ingredient;
import com.example.foodorder.entity.ingredient.BOConsume;
import com.example.foodorder.entity.ingredient.BORestock;
import com.example.foodorder.util.UUIDHelper;

@CrossOrigin
@RestController
@RequestMapping("ingredient")
public class IngredientController {

	@Autowired
	private IngredientService ingredientService;
	
	@GetMapping("list")
	public List<Ingredient> findAll() {
		return ingredientService.findAll();
	}
	
	@PostMapping
	public Ingredient save(@RequestBody Ingredient entity) {
		return ingredientService.save(entity);
	}
	
	@PutMapping
	public Ingredient update(@RequestBody Ingredient entity) {
		return ingredientService.update(entity);
	}
	
	@DeleteMapping("{uid}")
	public Ingredient delete(@PathVariable String uid) {
		return ingredientService.delete(uid);
	}
	
	@PatchMapping("restock")
	public Ingredient restock(@RequestBody BORestock bo) {
		return ingredientService.restock(bo, UUIDHelper.getBatchNo());
	}
	
	@GetMapping("{uid}/packagelist")
	public List<Ingredient> findPackageList(@PathVariable String uid) {
		return ingredientService.findPackageList(uid);
	}
	
	@PatchMapping("consume")
	public Ingredient cousume(@RequestBody BOConsume bo) throws Exception {
		return ingredientService.consume(bo, UUIDHelper.getBatchNo());
	}
}
