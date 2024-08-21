package com.anantmathur.tablebookingapp;

import com.anantmathur.tablebookingapp.Controller.ReservationController;
import com.anantmathur.tablebookingapp.model.Reservation;
import com.anantmathur.tablebookingapp.service.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ReservationControllerTest {

    @InjectMocks
    private ReservationController reservationController;

    @Mock
    private ReservationService reservationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testGetAllReservations() {
        List<Reservation> reservations = List.of(new Reservation());
        when(reservationService.getAllReservations()).thenReturn(reservations);

        ResponseEntity<List<Reservation>> response = reservationController.getAllReservations();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(reservationService, times(1)).getAllReservations();
    }

    @Test
    public void testGetReservationById() {
        Reservation reservation = new Reservation();
        when(reservationService.getReservationById(any(Long.class))).thenReturn(java.util.Optional.of(reservation));

        ResponseEntity<Reservation> response = reservationController.getReservationById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(reservationService, times(1)).getReservationById(1L);
    }
}
