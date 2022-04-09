package com.example.foodorder.bll.order;

import java.util.List;

import com.example.foodorder.entity.order.DinningTable;

public interface DinningTableService {
	public List<DinningTable> findAll();
	public DinningTable save(DinningTable entity);
	public DinningTable update(DinningTable entity);
	public DinningTable delete(String uid);
}
