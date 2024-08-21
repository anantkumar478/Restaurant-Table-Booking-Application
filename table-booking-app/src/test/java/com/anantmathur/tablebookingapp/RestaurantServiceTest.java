package com.anantmathur.tablebookingapp;

import com.anantmathur.tablebookingapp.model.Restaurant;
import com.anantmathur.tablebookingapp.repository.RestaurantRepository;
import com.anantmathur.tablebookingapp.service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RestaurantServiceTest {

    @Mock
    private RestaurantRepository restaurantRepository;

    @InjectMocks
    private RestaurantService restaurantService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddRestaurant() {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName("Test Restaurant");

        when(restaurantRepository.save(any(Restaurant.class))).thenReturn(restaurant);

        Restaurant createdRestaurant = restaurantService.addRestaurant(restaurant);

        assertEquals("Test Restaurant", createdRestaurant.getRestaurantName());
        verify(restaurantRepository, times(1)).save(restaurant);
    }

    @Test
    void testGetRestaurantById() {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(1L);
        restaurant.setRestaurantName("Test Restaurant");

        when(restaurantRepository.findById(1L)).thenReturn(Optional.of(restaurant));

        Optional<Restaurant> foundRestaurant = restaurantService.getRestaurantById(1L);

        assertEquals("Test Restaurant", foundRestaurant.get().getRestaurantName());
        verify(restaurantRepository, times(1)).findById(1L);
    }
}
