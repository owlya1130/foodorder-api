package com.example.foodorder.bll;

import java.util.List;

import com.example.foodorder.entity.Code;

public interface ReservationTimeBlockService {
	public List<Code> findAll();
	public Code save(Code entity);
	public Code update(Code entity);
}
