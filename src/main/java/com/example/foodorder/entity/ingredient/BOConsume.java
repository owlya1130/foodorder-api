package com.example.foodorder.entity.ingredient;

public class BOConsume {
	
	private String uid;
	private IngredientActionType actionType;
	private int qty;
	private String comment;
	private int packagedQty;
	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public IngredientActionType getActionType() {
		return actionType;
	}
	public void setActionType(IngredientActionType actionType) {
		this.actionType = actionType;
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
	public int getPackagedQty() {
		return packagedQty;
	}
	public void setPackagedQty(int packagedQty) {
		this.packagedQty = packagedQty;
	}
	
}
