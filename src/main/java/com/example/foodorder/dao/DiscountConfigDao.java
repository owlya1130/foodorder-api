package com.example.foodorder.dao;

import java.util.List;

import com.example.foodorder.entity.DiscountConfig;

public interface DiscountConfigDao {

	public List<DiscountConfig> findAll();
	public DiscountConfig save(DiscountConfig entity);
	public DiscountConfig update(DiscountConfig entity);
	public DiscountConfig delete(String uid);
	
}
