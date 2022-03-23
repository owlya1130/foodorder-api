package com.example.foodorder.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.foodorder.entity.Reservation;

@Repository
public class ReservationDaoImpl implements ReservationDao {

	@Autowired
	private EntityManager em;

	@Override
	public List<Reservation> findAll(Date startDateTime, Date endDateTime, String tableUid) {
		String hql = "from Reservation r where r.time between :start and :end";
		
		if (tableUid != null) {
			hql += " and r.tableUid = :tableUid";
		}

		TypedQuery<Reservation> query = em.createQuery(hql, Reservation.class).setParameter("start", startDateTime)
				.setParameter("end", endDateTime);
		
		if (tableUid != null) {
			query.setParameter("tableUid", tableUid);
		}
		
		return query.getResultList();
	}

	@Override
	public Reservation save(Reservation entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public Reservation update(Reservation entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public Reservation delete(int uid) {
		Reservation entity = em.find(Reservation.class, uid);
		em.remove(entity);
		return entity;
	}

}
