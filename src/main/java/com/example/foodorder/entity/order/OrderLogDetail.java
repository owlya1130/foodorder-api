package com.example.foodorder.entity.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.foodorder.entity.meal.Meal;

@Entity
@Table(name="order_log_detail")
public class OrderLogDetail {

	@Id
	@Column(name="uid")
	private String uid;	

	@Column(name="orderQty")
	private int orderQty;
	
	@Column(name="orderLogUid")
	private String orderLogUid; 
	
	@ManyToOne
	@JoinColumn(name="mealUid")
	private Meal meal;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public String getOrderLogUid() {
		return orderLogUid;
	}

	public void setOrderLogUid(String orderLogUid) {
		this.orderLogUid = orderLogUid;
	}

}
