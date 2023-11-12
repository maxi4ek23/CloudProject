package com.pelyshko.exception;

public class AdressNotFoundException extends RuntimeException {
	public AdressNotFoundException(Integer id) {
        super("Could not find 'adress' with id=" + id);
    }
}
