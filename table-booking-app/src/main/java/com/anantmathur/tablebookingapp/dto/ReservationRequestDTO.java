package com.anantmathur.tablebookingapp.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationRequestDTO {

    private Long userID;
    private Long tableID;
    private Long restaurantID;
    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private int partySize;

    // Constructors
    public ReservationRequestDTO() {
    }

    public ReservationRequestDTO(Long userID, Long tableID, Long restaurantID,
                                 LocalDate reservationDate, LocalTime reservationTime, int partySize) {
        this.userID = userID;
        this.tableID = tableID;
        this.restaurantID = restaurantID;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        this.partySize = partySize;
    }

    // Getters and Setters
    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getTableID() {
        return tableID;
    }

    public void setTableID(Long tableID) {
        this.tableID = tableID;
    }

    public Long getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(Long restaurantID) {
        this.restaurantID = restaurantID;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public int getPartySize() {
        return partySize;
    }

    public void setPartySize(int partySize) {
        this.partySize = partySize;
    }
}
