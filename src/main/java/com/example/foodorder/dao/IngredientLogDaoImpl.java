package com.example.foodorder.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.foodorder.entity.IngredientLog;

@Repository
public class IngredientLogDaoImpl implements IngredientLogDao {

	@Autowired
	private EntityManager em;

	@Override
	public List<IngredientLog> findAll(String ingredientUid) {
		return em.createQuery("from IngredientLog log where log.ingredientUid = :ingredientUid", IngredientLog.class)
				.setParameter("ingredientUid", ingredientUid).getResultList();
	}

	@Override
	public IngredientLog save(IngredientLog entity) {
		em.persist(entity);
		return entity;
	}

}
