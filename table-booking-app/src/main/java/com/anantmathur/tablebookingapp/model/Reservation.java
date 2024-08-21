package com.anantmathur.tablebookingapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reservations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long reservationID;  // Primary Key, Auto-Increment

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Foreign Key to User

    @ManyToOne
    @JoinColumn(name = "table_id", nullable = false)
    private RestaurantTable reservedTable;  // Foreign Key to Table

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;  // Foreign Key to Restaurant

    @Column(name = "reservation_date", nullable = false)
    private String reservationDate;  // Date of Reservation

    @Column(name = "reservation_time", nullable = false)
    private String reservationTime;  // Time of Reservation

    @Column(name = "party_size", nullable = false)
    private int partySize;  // Number of people for the reservation
}


