package com.pelyshko.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pelyshko.domain.Reservation;
import com.pelyshko.exception.ReservationNotFoundException;
import com.pelyshko.repository.ReservationRepository;
import com.pelyshko.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	ReservationRepository reservationRepository;
	
	@Override
	public Reservation findById(Integer id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));
    }
	
	@Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }
	
	@Override
	@Transactional
	public Reservation create(Reservation reservation) {
		reservationRepository.save(reservation);
        return reservation;
    }
	
	@Override
	@Transactional
    public void update(Integer id, Reservation newReservation) {
		Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));
		reservation.setIsPossible(newReservation.getIsPossible());
		reservation.setName(newReservation.getName());
		reservation.setTime(newReservation.getTime());
		reservation.setHowLong(newReservation.getHowLong());
		reservation.setIsConfirmed(newReservation.getIsConfirmed());
		reservationRepository.save(reservation);
    }
	
	@Override
	@Transactional
	public void delete(Integer id) {
		Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));
		reservationRepository.delete(reservation);
    }
}
