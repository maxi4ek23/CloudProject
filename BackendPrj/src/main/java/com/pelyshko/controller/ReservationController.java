package com.pelyshko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pelyshko.domain.Reservation;
import com.pelyshko.dto.ReservationDto;
import com.pelyshko.dto.assembler.ReservationDtoAssembler;
import com.pelyshko.service.ReservationService;


@RestController
@RequestMapping(value = "/api/reservations")
public class ReservationController {
	@Autowired
    private ReservationService reservationService;
    @Autowired
    private ReservationDtoAssembler reservationDtoAssembler;

    @GetMapping(value = "/{reservationId}")
    public ResponseEntity<ReservationDto> getReservation(@PathVariable Integer reservationId) {
    	Reservation reservation = reservationService.findById(reservationId);
    	ReservationDto reservationDto = reservationDtoAssembler.toModel(reservation);
        return new ResponseEntity<>(reservationDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<ReservationDto>> getAllReservations() {
        List<Reservation> reservations = reservationService.findAll();
        CollectionModel<ReservationDto> reservationDtos = reservationDtoAssembler.toCollectionModel(reservations);
        return new ResponseEntity<>(reservationDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<ReservationDto> addReservation(@RequestBody Reservation reservation) {
    	Reservation newReservation = reservationService.create(reservation);
    	ReservationDto reservationDto = reservationDtoAssembler.toModel(newReservation);
        return new ResponseEntity<>(reservationDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{reservationId}")
    public ResponseEntity<?> updateReservation(@RequestBody Reservation updReservation, @PathVariable Integer reservationId) {
    	reservationService.update(reservationId, updReservation);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{reservationId}")
    public ResponseEntity<?> deleteReservationn(@PathVariable Integer reservationId) {
    	reservationService.delete(reservationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
