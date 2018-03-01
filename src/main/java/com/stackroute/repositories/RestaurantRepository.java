package com.stackroute.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.domain.Restaurant;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
	public Restaurant findByrestaurantName(String restaurentName);
}
