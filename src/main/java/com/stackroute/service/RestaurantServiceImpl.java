package com.stackroute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mongodb.DuplicateKeyException;
import com.stackroute.domain.Restaurant;
import com.stackroute.exception.RestaurantAlreadyExistsException;
import com.stackroute.repositories.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	RestaurantRepository restaurantRepository;

	public Restaurant addRestaurant(Restaurant restaurant) throws RestaurantAlreadyExistsException{
		
		try{
		restaurantRepository.save(restaurant);
		}
		
		catch(Exception e){
			throw new RestaurantAlreadyExistsException("Restaurant already exists");
		}
		return restaurant;
	}

	public Restaurant searchById(int restaurantId) {
		Restaurant restaurant = restaurantRepository.findOne(restaurantId);
		return restaurant;
	}

	public List<Restaurant> findAll() {
		return (List<Restaurant>) restaurantRepository.findAll();

	}

	public String deleteRestaurant(int restaurantId) {
		restaurantRepository.delete(restaurantId);
		return "restaurant deleted";

	}

	@Autowired
	public void setRestaurantRepository(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}
	
	public Restaurant searchByrestaurantName(String restaurantName){
		Restaurant restaurant = restaurantRepository.findByrestaurantName(restaurantName);
		return restaurant;
		
	}
}
