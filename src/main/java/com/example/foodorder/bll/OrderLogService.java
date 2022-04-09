package com.example.foodorder.bll;

import java.util.List;

import com.example.foodorder.entity.order.OrderLog;

public interface OrderLogService {
	public List<OrderLog> findAll();
	public OrderLog save(OrderLog entity) throws Exception;
	public OrderLog update(OrderLog entity);
	public OrderLog delete(String uid);
}
