package com.hotel.v2soru.exception;

public class AdminListNotFound extends RuntimeException {
	String message;

	public String getMessage() {
		return message;
	}

	public AdminListNotFound(String message) {
		this.message = message;
	}
	
	

}
