package com.pelyshko.exception;

public class LesseeNotFoundException extends RuntimeException {
	public LesseeNotFoundException(Integer id) {
        super("Could not find 'lessee' with id=" + id);
    }
}
