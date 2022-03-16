package com.example.foodorder.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.foodorder.entity.Ingredient;

@Repository
public class IngredientDaoImpl implements IngredientDao {
	
	@Autowired
	private EntityManager em;

	@Override
	public List<Ingredient> findAll() {
		return em.createQuery("from Ingredient", Ingredient.class).getResultList();
	}

	@Override
	public Ingredient save(Ingredient entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public Ingredient update(Ingredient entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public Ingredient delete(String uid) {
		Ingredient entity = em.find(Ingredient.class, uid);
		em.remove(entity);
		return entity;
	}

	@Override
	public Ingredient find(String uid) {
		return em.find(Ingredient.class, uid);
	}

}
