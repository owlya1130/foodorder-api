package com.example.foodorder.dao.code;

import java.util.List;

import com.example.foodorder.entity.code.CodeType;

public interface CodeTypeDao {

	public  List<CodeType> find(String id);
	
}
