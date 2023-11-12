package com.pelyshko.exception;

public class RegionNotFoundException extends RuntimeException {
	public RegionNotFoundException(Integer id) {
        super("Could not find 'region' with id=" + id);
    }
}
