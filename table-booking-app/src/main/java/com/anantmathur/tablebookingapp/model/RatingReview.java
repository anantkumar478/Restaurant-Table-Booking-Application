package com.anantmathur.tablebookingapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "rating_review")
@Data // Lombok annotation to generate getters, setters
public class RatingReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Long ratingId;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "review", nullable = false)
    private String review;

}
