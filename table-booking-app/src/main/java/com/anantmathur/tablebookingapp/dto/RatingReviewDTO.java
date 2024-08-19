package com.anantmathur.tablebookingapp.dto;

import lombok.Data;

@Data
public class RatingReviewDTO {

    private Long ratingId;
    private Long restaurantId;  // Use Restaurant ID for reference
    private Long userId;        // Use User ID for reference
    private Integer rating;
    private String reviews;
}
