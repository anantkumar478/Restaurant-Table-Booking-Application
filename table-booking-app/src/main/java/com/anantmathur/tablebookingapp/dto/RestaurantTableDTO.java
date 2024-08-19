package com.anantmathur.tablebookingapp.dto;

import lombok.Data;

@Data
public class RestaurantTableDTO {

    private Long tableId;
    private Long restaurantId;  // Use Restaurant ID for reference
    private Integer tableNumber;
    private Integer totalSeats;
}
