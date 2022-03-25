package com.example.foodorder.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="discount_config")
public class DiscountConfig {
	
	@Id
	@Column(name="uid")
	private String uid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="operator")
	private String operator;
	
	@Column(name="value")
	private float value;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

}
