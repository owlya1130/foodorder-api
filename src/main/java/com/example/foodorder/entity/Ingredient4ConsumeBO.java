package com.example.foodorder.entity;

public class Ingredient4ConsumeBO {
	
	public enum ConsumeType {
		Expired,
		Packaged,
		Sold
	}
	
	private ConsumeType action;	
	private String uid;
	private int Qty;
	private int packagedQty;
	private String comment;
	
	public ConsumeType getAction() {
		return action;
	}
	public void setAction(ConsumeType action) {
		this.action = action;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getQty() {
		return Qty;
	}
	public void setQty(int qty) {
		Qty = qty;
	}
	public int getPackagedQty() {
		return packagedQty;
	}
	public void setPackagedQty(int packagedQty) {
		this.packagedQty = packagedQty;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
