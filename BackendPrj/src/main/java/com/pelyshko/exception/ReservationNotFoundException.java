package com.pelyshko.exception;

public class ReservationNotFoundException extends RuntimeException {
	
	public ReservationNotFoundException(Integer id) {
        super("Could not find 'reservation' with id=" + id);
    }
}
