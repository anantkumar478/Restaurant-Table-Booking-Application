package com.anantmathur.tablebookingapp.Controller;

import com.anantmathur.tablebookingapp.dto.RatingReviewDTO;
import com.anantmathur.tablebookingapp.model.RatingReview;
import com.anantmathur.tablebookingapp.service.RatingReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ratingreviews")
public class RatingReviewController {

    @Autowired
    private RatingReviewService ratingReviewService;

    @PostMapping
    public ResponseEntity<RatingReviewDTO> createRatingReview(@RequestBody RatingReview ratingReview) {
        RatingReviewDTO createdRatingReview = ratingReviewService.addRatingReview(ratingReview);
        return ResponseEntity.ok(createdRatingReview);
    }

    @GetMapping
    public ResponseEntity<List<RatingReview>> getAllRatingReviews() {
        List<RatingReview> ratingReviews = ratingReviewService.getAllRatingReviews();
        return ResponseEntity.ok(ratingReviews);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatingReview> getRatingReviewById(@PathVariable("id") Long id) {
        Optional<RatingReview> ratingReview = ratingReviewService.getAllRatingReviews()
                .stream()
                .filter(rr -> rr.getRatingId().equals(id))
                .findFirst();
        return ratingReview.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
