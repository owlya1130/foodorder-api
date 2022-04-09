package com.example.foodorder.entity.ingredient;

public class BORestock {
	
	private String uid;
	private int qty;
	private String comment;
	private IngredientActionType actionType;
	private int cost;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
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
	public IngredientActionType getActionType() {
		return actionType;
	}
	public void setActionType(IngredientActionType actionType) {
		this.actionType = actionType;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
}
