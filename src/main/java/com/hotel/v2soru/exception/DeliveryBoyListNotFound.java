package com.hotel.v2soru.exception;

public class DeliveryBoyListNotFound extends RuntimeException {
	String message;

	public String getMessage() {
		return message;
	}

	public DeliveryBoyListNotFound(String message) {
		this.message = message;
	}
	

}
