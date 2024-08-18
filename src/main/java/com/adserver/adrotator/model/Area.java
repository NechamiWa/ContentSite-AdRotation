package com.adserver.adrotator.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class Area {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int code;
	@Column
	private String name;
	@Column
	private boolean free;
	@Column
	private int pricePerMinute;
	@Column
	private int pricePerView;
	
	
	public boolean isFree() {
		return free;
	}
	
	public void setFree(boolean free) {
		this.free = free;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPricePerMinute() {
		return pricePerMinute;
	}
	public void setPricePerMinute(int pricePerMinute) {
		this.pricePerMinute = pricePerMinute;
	}
	
	public int getPricePerView() {
		return pricePerView;
	}
	
	public void setPricePerView(int pricePerView) {
		this.pricePerView = pricePerView;
	}
	public static final int TOP=1;
	public static final int LEFT=2;
	public static final int RIGHT=3;
	public static final int BOTTOM=4;
	

}
