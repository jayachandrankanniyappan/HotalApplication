package com.hotel.v2soru.exception;

public class FoodOrderNotFound extends RuntimeException {
	String message;

	public String getMessage() {
		return message;
	}

	public FoodOrderNotFound(String message) {
		this.message = message;
	}
	

}
