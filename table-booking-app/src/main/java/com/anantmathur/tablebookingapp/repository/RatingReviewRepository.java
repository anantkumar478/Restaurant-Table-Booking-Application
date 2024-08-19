package com.anantmathur.tablebookingapp.repository;

import com.anantmathur.tablebookingapp.model.RatingReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingReviewRepository extends JpaRepository<RatingReview, Long> {
}
