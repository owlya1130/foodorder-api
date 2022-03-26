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

import com.example.foodorder.bll.OrderLogService;
import com.example.foodorder.entity.OrderLog;

@CrossOrigin
@RestController
@RequestMapping("order-log")
public class OrderLogController {

	@Autowired
	private OrderLogService orderLogService;
	
	@GetMapping("list")
	public List<OrderLog> findAll() {
		return orderLogService.findAll();
	}
	
	@PostMapping
	public OrderLog save(@RequestBody OrderLog entity) throws Exception {
		return orderLogService.save(entity);
	}
	
	@PutMapping
	public OrderLog update(@RequestBody OrderLog entity) {
		return orderLogService.update(entity);
	}
}
