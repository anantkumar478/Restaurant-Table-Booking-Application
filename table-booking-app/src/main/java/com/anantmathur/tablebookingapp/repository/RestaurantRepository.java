package com.anantmathur.tablebookingapp.repository;

import com.anantmathur.tablebookingapp.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
