package com.stackroute.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.stackroute.domain.Restaurant;
import com.stackroute.repositories.RestaurantRepository;

@Service
public class RestaurantMemoryServiceImpl implements RestaurantService {
	
	List<Restaurant> restaurants = new ArrayList<Restaurant>();

	public Restaurant addRestaurant(Restaurant restaurant) {
		restaurants.add(restaurant);
		return restaurant;
	}


	public List<Restaurant> findAll() {
		return this.restaurants;

	}


}
