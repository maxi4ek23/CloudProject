package com.pelyshko.exception;

public class CountryNotFoundException extends RuntimeException {
	public CountryNotFoundException(Integer id) {
        super("Could not find 'region' with id=" + id);
    }
}
