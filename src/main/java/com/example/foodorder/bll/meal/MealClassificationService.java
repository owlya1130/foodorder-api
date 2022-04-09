package com.example.foodorder.bll.meal;

import java.util.List;

import com.example.foodorder.entity.code.Code;

public interface MealClassificationService {
	public List<Code> findAll();
	public Code save(Code entity);
	public Code update(Code entity);
	public Code delete(String uid);
}
