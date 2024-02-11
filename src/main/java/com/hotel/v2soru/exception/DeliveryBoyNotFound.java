package com.hotel.v2soru.exception;

public class DeliveryBoyNotFound extends RuntimeException {
	String message;

	public String getMessage() {
		return message;
	}

	public DeliveryBoyNotFound(String message) {
		this.message = message;
	}
	
	

}
