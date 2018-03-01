package com.stackroute.service.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.stackroute.domain.Restaurant;
import com.stackroute.repositories.RestaurantRepository;
import com.stackroute.service.RestaurantServiceImpl;

public class RestaurantServiceImplTest {
	
	
	private RestaurantServiceImpl restaurantServiceImpl;
	
	@Mock
	private RestaurantRepository restaurantRepository;
	
	@Mock
	private Restaurant restaurant;
	
	@Mock
	List<Restaurant> rest;

	
	@Before
	public void setUpMock(){
		MockitoAnnotations.initMocks(this);
		restaurantServiceImpl=new RestaurantServiceImpl();
		restaurantServiceImpl.setRestaurantRepository(restaurantRepository);
	}
	
	@Test
	public void shouldReturnRestaurant_whenGetRestaurantByIdIsCalled() throws Exception{
		
		//arrange
		when(restaurantRepository.save(restaurant)).thenReturn(restaurant);
		//act
		Restaurant retrievedProduct = restaurantServiceImpl.addRestaurant(restaurant);
		//assert
		assertThat(retrievedProduct, is(equalTo(restaurant)));
	}
	
	@Test
	public void shouldReturnRestaurantDelete_whenGetRestaurantByIdIsCalledDelete() throws Exception{
		
		// Arrange
        doNothing().when(restaurantRepository).delete(1);
        RestaurantRepository my = Mockito.mock(RestaurantRepository.class);
        // Act
        restaurantServiceImpl.deleteRestaurant(1);
        // Assert
        verify(restaurantRepository, times(1)).delete(1);
	}
	
    @Test
    public void shouldReturnProductSearch_whenGetProductByIdIsCalledSearch() throws Exception {
        // Arrange
        when(restaurantRepository.findOne(1)).thenReturn(restaurant);
        // Act
        Restaurant retrievedProduct = restaurantServiceImpl.searchById(1);
        // Assert
        assertThat(retrievedProduct, is(equalTo(restaurant)));
 
    }
    
    @Test
    public void shouldReturnProductSearchByName_whenGetProductByIdIsCalledSearchByName() throws Exception {
        String restaurantName = null;
		// Arrange
        when(restaurantRepository.findByrestaurantName(restaurantName)).thenReturn(restaurant);
        // Act
        Restaurant retrievedProduct = restaurantServiceImpl.searchByrestaurantName(restaurantName);
        // Assert
        assertThat(retrievedProduct, is(equalTo(restaurant)));
 
    }
    
    @Test
    public void shouldReturnProductSearchFindAll_whenGetProductByIdIsCalledFindAll() throws Exception {
        String restaurantName = null;
		// Arrange
        when(restaurantRepository.findAll()).thenReturn(rest);
        // Act
        List<Restaurant> retrievedProduct = restaurantServiceImpl.findAll();
        // Assert
        assertThat(retrievedProduct, is(equalTo(rest)));
 
    }


}
