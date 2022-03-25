package com.example.foodorder.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.foodorder.entity.DiscountConfig;

@Repository
public class DiscountConfigDaoImpl implements DiscountConfigDao {

	@Autowired
	private EntityManager em;

	@Override
	public List<DiscountConfig> findAll() {
		return em.createQuery("from DiscountConfig", DiscountConfig.class).getResultList();
	}

	@Override
	public DiscountConfig save(DiscountConfig entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public DiscountConfig update(DiscountConfig entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public DiscountConfig delete(String uid) {
		DiscountConfig entity = em.find(DiscountConfig.class, uid);
		em.remove(entity);
		return entity;
	}

}
