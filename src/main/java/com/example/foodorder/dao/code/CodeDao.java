package com.example.foodorder.dao.code;

import java.util.List;

import com.example.foodorder.entity.code.Code;

public interface CodeDao {

	public List<Code> findAll(String typeid);
	public Code save(Code entity);
	public Code update(Code entity);
	public Code delete(String uid);
	
}
