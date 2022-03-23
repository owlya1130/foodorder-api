package com.example.foodorder.dao;

import java.util.Date;
import java.util.List;

import com.example.foodorder.entity.Reservation;

public interface ReservationDao {
	public List<Reservation> findAll(Date startDateTime, Date endDateTime, String tableUid);
	public Reservation save(Reservation entity);
	public Reservation update(Reservation entity);
	public Reservation delete(int uid);
}
