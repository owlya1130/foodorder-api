package com.example.foodorder.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.foodorder.entity.order.OrderLog;

@Repository
public class OrderLogDaoImpl implements OrderLogDao {
	
	@Autowired
	private EntityManager em;

	@Override
	public List<OrderLog> findAll() {
		return em.createQuery("from OrderLog ol where ol.cleanTime is null", OrderLog.class).getResultList();
	}

	@Override
	public OrderLog save(OrderLog entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public OrderLog update(OrderLog entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public OrderLog delete(String uid) {
		OrderLog entity = em.find(OrderLog.class, uid);
		em.remove(entity);
		return entity;
	}

}
