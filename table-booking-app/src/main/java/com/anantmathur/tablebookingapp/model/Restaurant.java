package com.anantmathur.tablebookingapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "restaurants")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long restaurantId;

    @Column(name = "restaurant_name", nullable = false)
    private String restaurantName;

    @Column(name = "restaurant_location")
    private String restaurantLocation;

    @Column(name = "restaurant_total_table_count")
    private int restaurantTotalTableCount;

    @Column(name = "restaurant_description")
    private String restaurantDescription;

    @Column(name = "restaurant_city")
    private String restaurantCity;

}
