package com.pelyshko.exception;

public class DwellingNotFoundException extends RuntimeException {
	public DwellingNotFoundException(Integer id) {
        super("Could not find 'dwelling' with id=" + id);
    }
}
