package com.anantmathur.tablebookingapp.Controller;

import com.anantmathur.tablebookingapp.model.RatingReview;
import com.anantmathur.tablebookingapp.service.RatingReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rating-reviews")
public class RatingReviewController {

    @Autowired
    private RatingReviewService ratingReviewService;

    @PostMapping
    public ResponseEntity<RatingReview> createRatingReview(@RequestBody RatingReview ratingReview) {
        // Validate that the review field is not null
        if (ratingReview.getReviews() == null || ratingReview.getReviews().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        RatingReview createdRatingReview = ratingReviewService.addRatingReview(ratingReview);
        return ResponseEntity.ok(createdRatingReview);
    }

    @GetMapping
    public ResponseEntity<List<RatingReview>> getAllRatingReviews() {
        List<RatingReview> ratingReviews = ratingReviewService.getAllRatingReviews();
        return ResponseEntity.ok(ratingReviews);
    }
}
