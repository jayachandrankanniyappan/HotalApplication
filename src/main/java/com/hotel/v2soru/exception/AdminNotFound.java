package com.hotel.v2soru.exception;

public class AdminNotFound extends RuntimeException {
	
	String message;

	public String getMessage() {
		return message;
	}

	public AdminNotFound(String message) {
		this.message = message;
	}
	

}
