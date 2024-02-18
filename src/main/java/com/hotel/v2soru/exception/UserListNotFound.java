package com.hotel.v2soru.exception;

public class UserListNotFound extends RuntimeException {
	String message;

	public String getMessage() {
		return message;
	}

	public UserListNotFound(String message) {
		this.message = message;
	}
	
	

}
