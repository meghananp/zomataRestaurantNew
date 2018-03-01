package com.stackroute.domain;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Restaurant {
	@Id
	private String _id;
	@NotNull
	private String restaurantName;
	@NotNull
	private String restaurantLocation;
	@NotNull
	private BigDecimal costOfTwo;
	
/*	public Restaurant(int restaurantId, String restaurantName, String restaurantLocation, BigDecimal costOfTwo ){
		this.restaurantId=restaurantId;
		this.restaurantName=restaurantName;
		this.restaurantLocation=restaurantLocation;
		this.costOfTwo=costOfTwo;
	}*/

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantId() {
		return _id;
	}

	public void setRestaurantId(String restaurantId) {
		this._id = restaurantId;
	}

	public String getRestaurantLocation() {
		return restaurantLocation;
	}

	public void setRestaurantLocation(String restaurantLocation) {
		this.restaurantLocation = restaurantLocation;
	}

	public BigDecimal getCostOfTwo() {
		return costOfTwo;
	}

	public void setCostOfTwo(BigDecimal costOfTwo) {
		this.costOfTwo = costOfTwo;
	}

}
