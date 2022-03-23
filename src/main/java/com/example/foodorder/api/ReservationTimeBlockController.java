package com.example.foodorder.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodorder.bll.ReservationTimeBlockService;
import com.example.foodorder.entity.Code;

@CrossOrigin
@RestController
@RequestMapping("reservation-timeblock")
public class ReservationTimeBlockController {

	@Autowired
	private ReservationTimeBlockService reservationTimeBlockService;
	
	@GetMapping("list")
	public List<Code> findAll() {
		return reservationTimeBlockService.findAll();
	}
	
	@PostMapping
	public Code save(@RequestBody Code entity) {
		return reservationTimeBlockService.save(entity);
	}
	
	@PutMapping
	public Code update(@RequestBody Code entity) {
		return reservationTimeBlockService.update(entity);
	}
}
