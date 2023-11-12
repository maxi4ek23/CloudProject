package com.pelyshko.exception;

public class DwellingOwnerNotFoundBySurnameException extends RuntimeException {
	public DwellingOwnerNotFoundBySurnameException(String surname) {
        super("Could not find 'dwelling owner' with id=" + surname);
    }
}
