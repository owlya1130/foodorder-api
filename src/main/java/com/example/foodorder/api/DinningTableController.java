package com.example.foodorder.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodorder.bll.DinningTableService;
import com.example.foodorder.entity.DinningTable;

@CrossOrigin
@RestController
@RequestMapping("dinningtable")
public class DinningTableController {

	@Autowired
	private DinningTableService dinningTableService;
	
	@GetMapping("list")
	public List<DinningTable> findAll() {
		return dinningTableService.findAll();
	}
	
	@PostMapping
	public DinningTable save(@RequestBody DinningTable entity) {
		return dinningTableService.save(entity);
	}
	
	@PutMapping
	public DinningTable update(@RequestBody DinningTable entity) {
		return dinningTableService.update(entity);
	}
	
	@DeleteMapping("{uid}")
	public DinningTable delete(@PathVariable String uid) {
		return dinningTableService.delete(uid);
	}
}
