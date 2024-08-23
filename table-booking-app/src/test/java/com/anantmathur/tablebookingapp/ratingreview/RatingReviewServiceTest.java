package com.anantmathur.tablebookingapp.ratingreview;

import com.anantmathur.tablebookingapp.dto.RatingReviewDTO;
import com.anantmathur.tablebookingapp.model.RatingReview;
import com.anantmathur.tablebookingapp.model.Restaurant;
import com.anantmathur.tablebookingapp.model.User;
import com.anantmathur.tablebookingapp.repository.RatingReviewRepository;
import com.anantmathur.tablebookingapp.repository.RestaurantRepository;
import com.anantmathur.tablebookingapp.repository.UserRepository;
import com.anantmathur.tablebookingapp.service.RatingReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RatingReviewServiceTest {

    @Mock
    private RatingReviewRepository ratingReviewRepository;

    @Mock
    private RestaurantRepository restaurantRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private RatingReviewService ratingReviewService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddRatingReview() {
        // Create Restaurant and User instances
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(1L);

        User user = new User();
        user.setUserId(1L);

        // Create and initialize the RatingReview instance
        RatingReview ratingReview = new RatingReview();
        ratingReview.setRestaurant(restaurant);
        ratingReview.setUser(user);
        ratingReview.setRating(5);
        ratingReview.setReview("Great food!");

        // Mock the repository calls
        when(restaurantRepository.findById(anyLong())).thenReturn(Optional.of(restaurant));
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        when(ratingReviewRepository.save(any(RatingReview.class))).thenReturn(ratingReview);

        // Call the service method
        RatingReviewDTO result = ratingReviewService.addRatingReview(ratingReview);

        // Assertions: Compare relevant fields
        assertEquals(ratingReview.getRating(), result.getRating());
        assertEquals(ratingReview.getReview(), result.getReviews());
        assertEquals(ratingReview.getRestaurant().getRestaurantId(), result.getRestaurantId());
        assertEquals(ratingReview.getUser().getUserId(), result.getUserId());

        verify(ratingReviewRepository, times(1)).save(ratingReview);
    }
}
