package com.anantmathur.tablebookingapp;

import com.anantmathur.tablebookingapp.model.Reservation;
import com.anantmathur.tablebookingapp.model.Restaurant;
import com.anantmathur.tablebookingapp.model.RestaurantTable;
import com.anantmathur.tablebookingapp.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReservationTest {

    @Test
    public void testReservationFields() {
        User user = new User();
        Restaurant restaurant = new Restaurant();
        RestaurantTable table = new RestaurantTable();

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setRestaurant(restaurant);
        reservation.setReservedTable(table);
        reservation.setReservationDate("2024-08-21");
        reservation.setReservationTime("19:30:00");
        reservation.setPartySize(4);

        Assertions.assertEquals(user, reservation.getUser());
        Assertions.assertEquals(restaurant, reservation.getRestaurant());
        Assertions.assertEquals(table, reservation.getReservedTable());
        Assertions.assertEquals("2024-08-21", reservation.getReservationDate());
        Assertions.assertEquals("19:30:00", reservation.getReservationTime());
        Assertions.assertEquals(4, reservation.getPartySize());
    }
}
