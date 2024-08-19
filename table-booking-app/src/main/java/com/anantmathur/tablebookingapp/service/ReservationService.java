package com.anantmathur.tablebookingapp.service;

import com.anantmathur.tablebookingapp.model.Reservation;
import com.anantmathur.tablebookingapp.model.RestaurantTable;
import com.anantmathur.tablebookingapp.repository.ReservationRepository;
import com.anantmathur.tablebookingapp.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private TableRepository tableRepository;

    public Reservation addReservation(Reservation reservation) {
        // Check if the reservation already has a reservedTable
        if (reservation.getReservedTable() == null || reservation.getReservedTable().getTableId() == null) {
            throw new RuntimeException("Reserved table must be provided and must exist.");
        }

        // Fetch the table by ID to ensure it exists
        RestaurantTable reservedTable = tableRepository.findById(reservation.getReservedTable().getTableId())
                .orElseThrow(() -> new RuntimeException("Table not found"));

        // Set the fetched table in the reservation
        reservation.setReservedTable(reservedTable);

        // Save the reservation
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }
}
