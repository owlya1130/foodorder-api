package com.example.foodorder.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.foodorder.entity.Code;

@Repository
public class CodeDaoImpl implements CodeDao {
	
	@Autowired
	private EntityManager em;

	@Override
	public List<Code> findAll() {
		return em.createQuery("from Code", Code.class).getResultList();
	}

	@Override
	public Code save(Code entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public Code update(Code entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public Code delete(String uid) {
		Code entity = em.find(Code.class, uid);
		em.remove(entity);
		return entity;
	}

}
