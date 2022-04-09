package com.example.foodorder.entity.order;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="order_log")
public class OrderLog {

	@Id
	@Column(name="uid")
	private String uid;
	
	@Column(name="orderTime")
	private Date orderTime;
	
	@Column(name="serveTime")
	private Date serveTime;
	
	@Column(name="cleanTime")
	private Date cleanTime;
	
	@Column(name="tableUid")
	private String tableUid;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="orderLogUid")
	private List<OrderLogDetail> details;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getServeTime() {
		return serveTime;
	}

	public void setServeTime(Date serveTime) {
		this.serveTime = serveTime;
	}

	public Date getCleanTime() {
		return cleanTime;
	}

	public void setCleanTime(Date cleanTime) {
		this.cleanTime = cleanTime;
	}

	public String getTableUid() {
		return tableUid;
	}

	public void setTableUid(String tableUid) {
		this.tableUid = tableUid;
	}

	public List<OrderLogDetail> getDetails() {
		return details;
	}

	public void setDetails(List<OrderLogDetail> details) {
		this.details = details;
	}

}
