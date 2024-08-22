package com.anantmathur.tablebookingapp.service;

import com.anantmathur.tablebookingapp.dto.ReservationResponseDTO;
import com.anantmathur.tablebookingapp.model.Reservation;
import com.anantmathur.tablebookingapp.model.RestaurantTable;
import com.anantmathur.tablebookingapp.repository.ReservationRepository;
import com.anantmathur.tablebookingapp.repository.TableRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private TableRepository tableRepository;

    public ReservationResponseDTO createReservation(Reservation reservation) {
        // Validate the reserved table
        if (reservation.getReservedTable() == null || reservation.getReservedTable().getTableId() == null) {
            throw new IllegalArgumentException("Reserved table must be provided and must exist.");
        }

        // Fetch the table by ID
        RestaurantTable reservedTable = tableRepository.findById(reservation.getReservedTable().getTableId())
                .orElseThrow(() -> new EntityNotFoundException("Table not found"));

        // Set the fetched table in the reservation
        reservation.setReservedTable(reservedTable);

        // Save the reservation
        Reservation savedReservation = reservationRepository.save(reservation);

        // Map to ReservationResponseDTO
        return new ReservationResponseDTO(
                savedReservation.getReservationID(),
                savedReservation.getUser().getUserId(),
                savedReservation.getReservedTable().getTableId(),
                savedReservation.getRestaurant().getRestaurantId(),
                savedReservation.getReservationDate(),
                savedReservation.getReservationTime(),
                savedReservation.getPartySize()
        );
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }


}


