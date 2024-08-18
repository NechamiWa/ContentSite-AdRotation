package com.adserver.adrotator.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name = "advertisement")
@Entity
public class ViewsAdvertisement extends Advertisement {
	
	public ViewsAdvertisement() {
		// TODO Auto-generated constructor stub
	}
	@Column
	private int wantedViews;
	@Column
	private int amountViews;
	public int getWantedViews() {
		return wantedViews;
	}
	public void setWantedViews(int wantedViews) {
		this.wantedViews = wantedViews;
	}
	public int getAmountViews() {
		return amountViews;
	}
	public void setAmountViews(int amountViews) {
		this.amountViews = amountViews;
	}

}
