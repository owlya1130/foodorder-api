package com.example.foodorder.api.meal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodorder.bll.meal.MealService;
import com.example.foodorder.entity.meal.Meal;

@CrossOrigin
@RestController
@RequestMapping("meal")
public class MealController {

	@Autowired
	private MealService mealService;
	
	@GetMapping("list")
	public List<Meal> findAll() {
		return mealService.findAll();
	}
	
	@PostMapping
	public Meal save(@RequestBody Meal entity) {
		return mealService.save(entity);
	}
	
	@PutMapping
	public Meal update(@RequestBody Meal entity) {
		return mealService.update(entity);
	}
}
