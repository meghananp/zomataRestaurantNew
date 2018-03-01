package com.stackroute.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stackroute.domain.Restaurant;
import com.stackroute.exception.RestaurantAlreadyExistsException;

@Service
public interface RestaurantService {
	
	public Restaurant addRestaurant(Restaurant restaurant) throws RestaurantAlreadyExistsException;
	public List<Restaurant> findAll();

}
