package com.example.foodorder.entity.order;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation {

	@Id
	@Column(name="uid")
	private int uid;
	
	@Column(name="time")
	private Date time;
	
	@Column(name="name")
	private String name;
	
	@Column(name="contactNo")
	private String contactNo;
	
	@Column(name="adults")
	private int adults;
	
	@Column(name="children")
	private int children;
	
	@Column(name="tableUid")
	private String tableUid;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public String getTableUid() {
		return tableUid;
	}

	public void setTableUid(String tableUid) {
		this.tableUid = tableUid;
	}

}
