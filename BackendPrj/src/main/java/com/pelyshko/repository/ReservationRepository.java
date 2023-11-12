package com.pelyshko.repository;

import org.springframework.stereotype.Repository;
import com.pelyshko.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
