package com.example.foodorder.bll;

import java.util.List;

import com.example.foodorder.entity.DinningTable;

public interface DinningTableService {
	public List<DinningTable> findAll();
	public DinningTable save(DinningTable entity);
	public DinningTable update(DinningTable entity);
	public DinningTable delete(String uid);
}
