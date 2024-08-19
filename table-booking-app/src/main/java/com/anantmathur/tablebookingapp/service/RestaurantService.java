package com.anantmathur.tablebookingapp.service;

import com.anantmathur.tablebookingapp.model.Restaurant;
import com.anantmathur.tablebookingapp.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant addRestaurant(Restaurant restaurant) {

        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public <Restaurant> Optional<Restaurant> getRestaurantById(Long id) {
        return (Optional<Restaurant>) restaurantRepository.findById(id);
    }
}

