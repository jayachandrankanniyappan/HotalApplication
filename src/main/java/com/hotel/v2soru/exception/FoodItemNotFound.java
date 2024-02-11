package com.hotel.v2soru.exception;

public class FoodItemNotFound extends RuntimeException  {
	String message;

	public String getMessage() {
		return message;
	}

	public FoodItemNotFound(String message) {
		this.message = message;
	}
	

}
