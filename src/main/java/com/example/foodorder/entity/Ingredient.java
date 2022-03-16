package com.example.foodorder.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ingredient")
public class Ingredient {

	@Id
	@Column(name="uid")
	private String uid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="qty")
	private int qty;
	
	@Column(name="packageByUID")
	private String packageByUID;
	
	@Column(name="packageQty")
	private int packageQty;

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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getPackageByUID() {
		return packageByUID;
	}

	public void setPackageByUID(String packageByUID) {
		this.packageByUID = packageByUID;
	}

	public int getPackageQty() {
		return packageQty;
	}

	public void setPackageQty(int packageQty) {
		this.packageQty = packageQty;
	}
}
