package com.anantmathur.tablebookingapp;

import com.anantmathur.tablebookingapp.Controller.RestaurantController;
import com.anantmathur.tablebookingapp.model.Restaurant;
import com.anantmathur.tablebookingapp.service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class RestaurantServiceTest {

    @Mock
    private RestaurantService restaurantService;

    @InjectMocks
    private RestaurantController restaurantController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(restaurantController).build();
    }

    @Test
    void testGetAllRestaurants() throws Exception {
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setRestaurantName("Test Restaurant 1");

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setRestaurantName("Test Restaurant 2");

        when(restaurantService.getAllRestaurants()).thenReturn(Arrays.asList(restaurant1, restaurant2));

        mockMvc.perform(get("/api/restaurants")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'restaurantName':'Test Restaurant 1'},{'restaurantName':'Test Restaurant 2'}]"));
    }

    @Test
    void testGetRestaurantById() throws Exception {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(1L);
        restaurant.setRestaurantName("Test Restaurant");

        when(restaurantService.getRestaurantById(1L)).thenReturn(Optional.of(restaurant));

        mockMvc.perform(get("/api/restaurants/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{'restaurantName':'Test Restaurant'}"));
    }
}
