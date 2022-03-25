package com.example.foodorder.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.foodorder.entity.Meal;

@Repository
public class MealDaoImpl implements MealDao {

	@Autowired
	private EntityManager em;

	@Override
	public List<Meal> findAll() {
		return em.createQuery("from Meal", Meal.class).getResultList();
	}

	@Override
	public Meal save(Meal entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public Meal update(Meal entity) {
		em.createQuery("delete from MealIngredient mi where mi.uid.mealUid = :mealUid ")
				.setParameter("mealUid", entity.getUid()).executeUpdate();
		em.merge(entity);
		return entity;
	}

	@Override
	public Meal delete(String uid) {
		Meal entity = em.find(Meal.class, uid);
		em.remove(entity);
		return entity;
	}

}
