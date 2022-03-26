package com.example.foodorder.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ingredient_Log")
public class IngredientLog {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="uid")
	private int uid;
	
	@Column(name="time")
	private Date time;
	
	@Column(name="action")
	private String action;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="ingredientUid")
	private String ingredientUid;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="batchno")
	private String batchno;
	
	public IngredientLog(String comment, String ingredientUid, String batchno) {
		this.comment = comment;
		this.ingredientUid = ingredientUid;
		this.time = new Date();
		this.batchno = batchno;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getIngredientUid() {
		return ingredientUid;
	}

	public void setIngredientUid(String ingredientUid) {
		this.ingredientUid = ingredientUid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}
	
}
