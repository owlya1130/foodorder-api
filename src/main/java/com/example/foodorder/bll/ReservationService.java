package com.example.foodorder.bll;

import java.util.Date;
import java.util.List;

import com.example.foodorder.entity.order.Reservation;

public interface ReservationService {
	public List<Reservation> findAll(Date startDate, Date endDate);
	public Reservation save(Reservation entity);
	public Reservation update(Reservation entity);
	public Reservation delete(int uid);
}
