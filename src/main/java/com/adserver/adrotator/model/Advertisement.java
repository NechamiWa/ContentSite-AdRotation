package com.adserver.adrotator.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table
public class Advertisement {
	
	public Advertisement() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
	
	@Column
	private int areaCode;
	
	@Column
	private boolean active;
	
	@Column
	private int customerCode;
	
	@Column
	private Date orderDate;
	
	
	@ManyToOne
	@JoinColumn(name = "areaCode",referencedColumnName = "code",insertable = false,updatable = false)
	private Area area_;
	
	@ManyToOne
	@JoinColumn(name = "customerCode",referencedColumnName = "code",insertable = false,updatable = false)
	private Customer customer_;
	
	public Date getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	
	public Customer getCustomer_() {
		return customer_;
	}
	
	public void setCustomer_(Customer customer) {
		this.customer_ = customer;
	}
	
	public int getCustomerCode() {
		return customerCode;
	}
	
	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}
	
	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}

	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}

	public int getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}

	//public abstract void init();

	public Area getArea_() {
		return area_;
	}


	public void setArea_(Area area) {
		this.area_ = area;
	}
}
