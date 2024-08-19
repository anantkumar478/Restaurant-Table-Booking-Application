package com.anantmathur.tablebookingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDTO {
    private Long restaurantId;
    private String restaurantName;
    private String restaurantLocation;
    private String restaurantCity;
    private int restaurantTotalTableCount;
}
