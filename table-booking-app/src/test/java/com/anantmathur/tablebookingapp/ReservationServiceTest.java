package com.anantmathur.tablebookingapp;

import com.anantmathur.tablebookingapp.dto.ReservationResponseDTO;
import com.anantmathur.tablebookingapp.model.Reservation;
import com.anantmathur.tablebookingapp.model.Restaurant;
import com.anantmathur.tablebookingapp.model.RestaurantTable;
import com.anantmathur.tablebookingapp.model.User;
import com.anantmathur.tablebookingapp.repository.ReservationRepository;
import com.anantmathur.tablebookingapp.repository.TableRepository;
import com.anantmathur.tablebookingapp.service.ReservationService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private TableRepository tableRepository;

    @InjectMocks
    private ReservationService reservationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateReservation() {
        User user = new User(1L, "John Doe", "john@example.com", "password", "1234567890", "123 Main St");
        Restaurant restaurant = new Restaurant(1L, "Restaurant Name", "City", 10, "Location", "Mumbai");
        RestaurantTable table = new RestaurantTable(1L, 1L, 1, 4);
        Reservation reservation = new Reservation(1L, user, table, restaurant, "2024-08-21", "19:30:00", 4);

        // Mock repository calls
        when(tableRepository.findById(1L)).thenReturn(Optional.of(table));
        when(reservationRepository.save(any(Reservation.class))).thenReturn(reservation);

        // Perform the service call
        ReservationResponseDTO createdReservation = reservationService.createReservation(reservation);

        // Log the response for debugging
        System.out.println("Created Reservation DTO: " + createdReservation);

        // Assertions
        assertNotNull(createdReservation);
        assertEquals(1L, createdReservation.getTableId());
        assertEquals(4, createdReservation.getPartySize());
    }


    @Test
    void testGetReservationById() {
        User user = new User(1L, "John Doe", "john@example.com", "password", "1234567890", "123 Main St");
        Restaurant restaurant = new Restaurant(1L, "Restaurant Name", "City", 11, "Hyderabad famous", "Chandigarh");
        RestaurantTable table = new RestaurantTable(1L, 1L, 1, 4);
        Reservation reservation = new Reservation(1L, user, table, restaurant, "2024-08-25",  "19:30:00", 4);

        when(reservationRepository.findById(1L)).thenReturn(Optional.of(reservation));

        Optional<Reservation> foundReservation = reservationService.getReservationById(1L);
        assertTrue(foundReservation.isPresent());
        assertEquals(1L, foundReservation.get().getReservationID());
    }

    @Test
    void testGetReservationById_NotFound() {
        when(reservationRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Reservation> foundReservation = reservationService.getReservationById(1L);
        assertFalse(foundReservation.isPresent());
    }
}
