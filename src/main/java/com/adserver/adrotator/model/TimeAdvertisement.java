package com.adserver.adrotator.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name = "advertisement")
@Entity
public class TimeAdvertisement extends Advertisement implements Serializable {

	public TimeAdvertisement() {
		// TODO Auto-generated constructor stub
	}

	@Column
	private int minutes;

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

}
