package com.hotel.v2soru.exception;

public class FoodItemListNotFound extends RuntimeException {
	String message;

	public String getMessage() {
		return message;
	}

	public FoodItemListNotFound(String message) {
		this.message = message;
	}
	

}
