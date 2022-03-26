package com.example.foodorder.dao;

import java.util.List;

import com.example.foodorder.entity.OrderLog;

public interface OrderLogDao {

	public List<OrderLog> findAll();
	public OrderLog save(OrderLog entity);
	public OrderLog update(OrderLog entity);
	public OrderLog delete(String uid);
	
}
