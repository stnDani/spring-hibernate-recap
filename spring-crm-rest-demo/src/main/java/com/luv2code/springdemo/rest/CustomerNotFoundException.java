package com.luv2code.springdemo.rest;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3648330992129069928L;

	public CustomerNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomerNotFoundException(String message) {
		super(message);
	}

	public CustomerNotFoundException(Throwable cause) {
		super(cause);
	}
}
