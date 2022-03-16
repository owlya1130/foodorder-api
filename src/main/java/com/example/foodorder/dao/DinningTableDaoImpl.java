package com.example.foodorder.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.foodorder.entity.DinningTable;

@Repository
public class DinningTableDaoImpl implements DinningTableDao {
	
	@Autowired
	private EntityManager em;

	@Override
	public List<DinningTable> findAll() {
		return em.createQuery("from DinningTable", DinningTable.class).getResultList();
	}

	@Override
	public DinningTable save(DinningTable entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public DinningTable update(DinningTable entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public DinningTable delete(String uid) {
		DinningTable entity = em.find(DinningTable.class, uid);
		em.remove(entity);
		return entity;
	}

}
