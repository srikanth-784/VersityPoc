package com.mail.exception;

public class InvalidMailDetails extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public InvalidMailDetails(String message) {
		super(message);
	}
	
}