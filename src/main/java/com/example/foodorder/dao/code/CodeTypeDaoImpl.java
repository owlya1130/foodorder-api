package com.example.foodorder.dao.code;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.foodorder.entity.code.CodeType;

@Repository
public class CodeTypeDaoImpl implements CodeTypeDao {
	
	@Autowired
	private EntityManager em;

	@Override
	public List<CodeType> find(String id) {
		return em.createQuery("from CodeType ct where ct.id = :id", CodeType.class)
				.setParameter("id", id).getResultList();
	}

}
