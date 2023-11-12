package com.pelyshko.exception;

public class DwellingOwnerNotFoundException extends RuntimeException {
	public DwellingOwnerNotFoundException(Integer id) {
        super("Could not find 'dwelling owner' with id=" + id);
    }
}
