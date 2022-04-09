package com.example.foodorder.api.order;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodorder.bll.ReservationService;
import com.example.foodorder.entity.order.Reservation;

@CrossOrigin
@RestController
@RequestMapping("reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@GetMapping("list")
	public List<Reservation> findAll(@RequestParam(name = "start") Date startDate,  @RequestParam(name = "end", required = false) Date endDate) {
		return reservationService.findAll(startDate, endDate);
	}
	
	@PostMapping
	public Reservation save(@RequestBody Reservation entity) {
		return reservationService.save(entity);
	}
	
	@PutMapping
	public Reservation update(@RequestBody Reservation entity) {
		return reservationService.update(entity);
	}
}
