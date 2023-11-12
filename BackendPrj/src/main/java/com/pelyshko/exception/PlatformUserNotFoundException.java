package com.pelyshko.exception;

public class PlatformUserNotFoundException extends RuntimeException {
	public PlatformUserNotFoundException(Integer id) {
        super("Could not find 'platform user' with id=" + id);
    }
}
