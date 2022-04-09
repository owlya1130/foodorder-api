package com.example.foodorder.api.meal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodorder.bll.meal.MealClassificationService;
import com.example.foodorder.entity.code.Code;

@CrossOrigin
@RestController
@RequestMapping("meal-classification")
public class MealClassificationController {

	@Autowired
	private MealClassificationService mealClassificationService;
	
	@GetMapping("list")
	public List<Code> findAll() {
		return mealClassificationService.findAll();
	}
	
	@PostMapping
	public Code save(@RequestBody Code entity) {
		return mealClassificationService.save(entity);
	}
	
	@PutMapping
	public Code update(@RequestBody Code entity) {
		return mealClassificationService.update(entity);
	}
	
	@DeleteMapping("{uid}")
	public Code delete(@PathVariable String uid) {
		return mealClassificationService.delete(uid);
	}
}
