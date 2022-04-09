package com.example.foodorder.bll.order;

import java.util.List;

import com.example.foodorder.entity.code.Code;

public interface ReservationTimeBlockService {
	public List<Code> findAll();
	public Code save(Code entity);
	public Code update(Code entity);
}
