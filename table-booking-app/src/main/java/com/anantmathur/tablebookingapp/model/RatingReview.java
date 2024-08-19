package com.anantmathur.tablebookingapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RatingReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Integer rating;  // Ensure this field allows null if not always required

    @Column(nullable = false)
    private String reviews;  // Ensure this field is not null and is set in your payload

    // getters and setters
}
