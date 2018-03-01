package com.stackroute.controller.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.stackroute.controller.RestaurantController;
import com.stackroute.domain.Restaurant;
import com.stackroute.repositories.RestaurantRepository;
import com.stackroute.service.RestaurantServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:test-context.xml", "classpath:mockTestBeans.xml"})
public class RestaurantControllerTest {
	
	@InjectMocks
	RestaurantController restaurantController;
	@Mock
	Restaurant restaurant;
	
	@Mock
	RestaurantServiceImpl restaurantServiceImpl;
	
	@Mock
	RestaurantRepository restaurantRepository;

	private MockMvc mockMvc;
    @Before
    public void setUp() throws Exception {
    	MockitoAnnotations.initMocks(this);
    	mockMvc = MockMvcBuilders.standaloneSetup(restaurantController).build();
    }
	
	@Test
	public void testAdd() throws Exception{
		
		int restaurantId=3;
		
		mockMvc.perform(MockMvcRequestBuilders.get("/restaurant"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("restaurant.id", is(restaurantId)))
        .andExpect(jsonPath("restaurant.name", is("Ocean")))
        .andExpect(jsonPath("restaurant.location", is("Bangalore")))
        .andExpect(jsonPath("restaurant.costoftwo", is(200)))
        .andExpect(jsonPath("success", is(true)));
	}
	
}
