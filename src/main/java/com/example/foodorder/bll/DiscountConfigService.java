package com.example.foodorder.bll;

import java.util.List;

import com.example.foodorder.entity.DiscountConfig;

public interface DiscountConfigService {
	public List<DiscountConfig> findAll();
	public DiscountConfig save(DiscountConfig entity);
	public DiscountConfig update(DiscountConfig entity);
	public DiscountConfig delete(String uid);
}
