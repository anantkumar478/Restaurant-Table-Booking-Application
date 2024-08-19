package com.anantmathur.tablebookingapp.repository;

import com.anantmathur.tablebookingapp.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
