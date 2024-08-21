package com.anantmathur.tablebookingapp;

import com.anantmathur.tablebookingapp.model.RatingReview;
import com.anantmathur.tablebookingapp.model.Restaurant;
import com.anantmathur.tablebookingapp.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RatingReviewTest {

    @Test
    public void testRatingReviewCreation() {
        // Create Restaurant and User instances
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(1L);

        User user = new User();
        user.setUserId(1L);

        // Create RatingReview instance
        RatingReview ratingReview = new RatingReview();
        ratingReview.setRatingId(1L);
        ratingReview.setRestaurant(restaurant);
        ratingReview.setUser(user);
        ratingReview.setRating(5);
        ratingReview.setReview("Great food!");

        // Assertions
        assertNotNull(ratingReview);
        assertEquals(1L, ratingReview.getRatingId());
        assertEquals(restaurant, ratingReview.getRestaurant());
        assertEquals(user, ratingReview.getUser());
        assertEquals(5, ratingReview.getRating());
        assertEquals("Great food!", ratingReview.getReview());
    }
}
