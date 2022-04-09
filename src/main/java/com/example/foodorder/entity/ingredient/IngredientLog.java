package com.example.foodorder.entity.ingredient;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="IngredientLog")
public class IngredientLog {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="uid")
	private int uid;
	
	@Column(name="batchno")
	private String batchno;
	
	@Column(name="time")
	private Date time;

	@Column(name="action")
	@Enumerated(EnumType.STRING)
	private IngredientActionType action;
	
	@Column(name="qty")
	private int qty;
	
	@Column(name="comment")
	private String comment;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public IngredientActionType getAction() {
		return action;
	}

	public void setAction(IngredientActionType action) {
		this.action = action;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
