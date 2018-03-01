package com.stackroute.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.domain.Restaurant;
import com.stackroute.exception.RestaurantAlreadyExistsException;
import com.stackroute.service.RestaurantService;
import com.stackroute.service.RestaurantServiceImpl;

@RestController
@RequestMapping("ap1/v1")
public class RestaurantController {

	private RestaurantService restaurantService;
	
    @Autowired
    @Qualifier("restaurantServiceImpl")
	public void setRestaurantService(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}
	@PostMapping("/restaurant")
	public ResponseEntity<?> addRestaurant(@RequestBody Restaurant restaurant) {
		Restaurant addedRestaurant;
		try {
			addedRestaurant = restaurantService.addRestaurant(restaurant);
		} catch (RestaurantAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
			
		}
		return new ResponseEntity<Restaurant>(addedRestaurant, HttpStatus.CREATED);

	}

	@DeleteMapping("/restaurant/{id}")
	public ResponseEntity<String> deleteRestaurant(@PathVariable("id") int restaurantId) {
		String delete = ((RestaurantServiceImpl) restaurantService).deleteRestaurant(restaurantId);
		return new ResponseEntity<String>(delete, HttpStatus.OK);

	}

	@GetMapping("/restaurant/{id}")
	public ResponseEntity<Restaurant> searchById(@PathVariable int restaurantId) {
		Restaurant searchRestaurant = ((RestaurantServiceImpl) restaurantService).searchById(restaurantId);
		return new ResponseEntity<Restaurant>(searchRestaurant, HttpStatus.OK);

	}

	@RequestMapping(value="/restaurant", method=RequestMethod.GET)
	public ResponseEntity<List<Restaurant>> findAllRestaurant() {
		List<Restaurant> listOfRestaurant = restaurantService.findAll();
		return new ResponseEntity<List<Restaurant>>(listOfRestaurant, HttpStatus.OK);

	}
	
	@GetMapping("/restaurant/{name}")
	public ResponseEntity<Restaurant> searchByrestaurantName(@PathVariable("name") String restaurantName) {
		Restaurant searchRestaurant = ((RestaurantServiceImpl) restaurantService).searchByrestaurantName(restaurantName);
		return new ResponseEntity<Restaurant>(searchRestaurant, HttpStatus.OK);

	}

	
}
