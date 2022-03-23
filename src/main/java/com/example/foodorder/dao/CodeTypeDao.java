package com.example.foodorder.dao;

import java.util.List;

import com.example.foodorder.entity.CodeType;

public interface CodeTypeDao {

	public  List<CodeType> find(String id);
	
}
