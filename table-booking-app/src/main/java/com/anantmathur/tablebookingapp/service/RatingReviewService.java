package com.anantmathur.tablebookingapp.service;

import com.anantmathur.tablebookingapp.dto.RatingReviewDTO;
import com.anantmathur.tablebookingapp.model.RatingReview;
import com.anantmathur.tablebookingapp.repository.RatingReviewRepository;
import com.anantmathur.tablebookingapp.repository.RestaurantRepository;
import com.anantmathur.tablebookingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingReviewService {

    @Autowired
    private RatingReviewRepository ratingReviewRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private UserRepository userRepository;

    public RatingReviewDTO addRatingReview(RatingReview ratingReview) {
        // Ensure that the restaurant and user exist
        if (restaurantRepository.findById(ratingReview.getRestaurant().getRestaurantId()).isEmpty() ||
                userRepository.findById(ratingReview.getUser().getUserId()).isEmpty()) {
            throw new RuntimeException("Invalid restaurant or user ID.");
        }

        // Save the rating and review
        RatingReview savedRatingReview = ratingReviewRepository.save(ratingReview);

        // Convert the saved entity to a DTO and return it
        return convertToDTO(savedRatingReview);
    }

    private RatingReviewDTO convertToDTO(RatingReview ratingReview) {
        RatingReviewDTO dto = new RatingReviewDTO();
        dto.setRatingId(ratingReview.getRatingId());
        dto.setRestaurantId(ratingReview.getRestaurant().getRestaurantId());
        dto.setUserId(ratingReview.getUser().getUserId());
        dto.setRating(ratingReview.getRating());
        dto.setReviews(ratingReview.getReview());
        return dto;
    }


    public List<RatingReview> getAllRatingReviews() {
        return ratingReviewRepository.findAll();
    }

}
