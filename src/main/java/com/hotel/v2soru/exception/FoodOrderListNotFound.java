package com.hotel.v2soru.exception;

public class FoodOrderListNotFound extends RuntimeException {
	String message;

	public String getMessage() {
		return message;
	}

	public FoodOrderListNotFound(String message) {
		this.message = message;
	}
	

}
