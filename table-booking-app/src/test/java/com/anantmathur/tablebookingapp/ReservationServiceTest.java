package com.anantmathur.tablebookingapp;

import com.anantmathur.tablebookingapp.model.Reservation;
import com.anantmathur.tablebookingapp.model.Restaurant;
import com.anantmathur.tablebookingapp.model.RestaurantTable;
import com.anantmathur.tablebookingapp.model.User;
import com.anantmathur.tablebookingapp.repository.ReservationRepository;
import com.anantmathur.tablebookingapp.repository.RestaurantRepository;
import com.anantmathur.tablebookingapp.repository.TableRepository;
import com.anantmathur.tablebookingapp.repository.UserRepository;
import com.anantmathur.tablebookingapp.service.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ReservationServiceTest {

    @InjectMocks
    private ReservationService reservationService;

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private RestaurantRepository restaurantRepository;

    @Mock
    private TableRepository tableRepository;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddReservation() {
        User user = new User();
        Restaurant restaurant = new Restaurant();
        RestaurantTable table = new RestaurantTable();
        Reservation reservation = new Reservation();

        when(userRepository.findById(any(Long.class))).thenReturn(Optional.of(user));
        when(restaurantRepository.findById(any(Long.class))).thenReturn(Optional.of(restaurant));
        when(tableRepository.findById(any(Long.class))).thenReturn(Optional.of(table));
        when(reservationRepository.save(any(Reservation.class))).thenReturn(reservation);

        Reservation createdReservation = reservationService.addReservation(reservation);

        verify(reservationRepository, times(1)).save(reservation);
    }

    @Test
    public void testGetAllReservations() {
        reservationService.getAllReservations();
        verify(reservationRepository, times(1)).findAll();
    }
}
