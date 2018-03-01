package com.stackroute.exception;

public class RestaurantAlreadyExistsException extends Exception {
	
	public RestaurantAlreadyExistsException(){
		super();
	}
	
	public RestaurantAlreadyExistsException(String message){
		super(message);
		System.out.println(message);
	}

}
