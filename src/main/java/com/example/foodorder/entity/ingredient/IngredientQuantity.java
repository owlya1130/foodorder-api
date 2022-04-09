package com.example.foodorder.entity.ingredient;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="IngredientQuantity")
public class IngredientQuantity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="uid")
	private int uid;
	
	@Column(name="ingredientUid")
	private String ingredientUid;
	
	@Column(name="qty")
	private int qty;
	
	@Column(name="cost")
	private int cost;
	
	@Column(name="create_time")
	private Date createTime;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="ingredientQuantityUid")
	private List<IngredientLog> logs;
	
	public IngredientQuantity() {
		createTime = new Date();
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getIngredientUid() {
		return ingredientUid;
	}

	public void setIngredientUid(String ingredientUid) {
		this.ingredientUid = ingredientUid;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public List<IngredientLog> getLogs() {
		return logs;
	}

	public void setLogs(List<IngredientLog> logs) {
		this.logs = logs;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
