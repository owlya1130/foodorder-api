package com.example.foodorder.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodorder.bll.DiscountConfigService;
import com.example.foodorder.entity.DiscountConfig;

@CrossOrigin
@RestController
@RequestMapping("discount-config")
public class DiscountConfigController {

	@Autowired
	private DiscountConfigService discountConfigService;
	
	@GetMapping("list")
	public List<DiscountConfig> findAll() {
		return discountConfigService.findAll();
	}
	
	@PostMapping
	public DiscountConfig save(@RequestBody DiscountConfig entity) {
		return discountConfigService.save(entity);
	}
	
	@PutMapping
	public DiscountConfig update(@RequestBody DiscountConfig entity) {
		return discountConfigService.update(entity);
	}
}
