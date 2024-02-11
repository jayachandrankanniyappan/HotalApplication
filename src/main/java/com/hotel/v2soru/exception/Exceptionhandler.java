package com.hotel.v2soru.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hotel.v2soru.util.ResponseStructure;

@RestControllerAdvice
public class Exceptionhandler extends RuntimeException {
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>>AdminNotFoundExResponseEntity(AdminNotFound ex){
		ResponseStructure<String>structure=new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("admin does not exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value() );
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>>UserNotFoundExResponseEntity(UserNotFound ex){
		ResponseStructure<String>structure=new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("user does not exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value() );
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>>DeliveryBoyNotFoundExResponseEntity(DeliveryBoyNotFound ex){
		ResponseStructure<String>structure=new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("DeliveryBoy does not exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value() );
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>>DeliveryBoyListNotFoundExResponseEntity(DeliveryBoyListNotFound ex){
		ResponseStructure<String>structure=new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("DeliveryBoy List does not exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value() );
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>>FoodOrderNotFoundExResponseEntity(FoodOrderNotFound ex){
		ResponseStructure<String>structure=new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Foodorder does not exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value() );
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>>FoodOrderListNotFoundExResponseEntity(FoodOrderListNotFound ex){
		ResponseStructure<String>structure=new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Foodorder List does not exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value() );
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>>FoodItemNotFoundExResponseEntity(FoodItemNotFound ex){
		ResponseStructure<String>structure=new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("FoodItem does not exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value() );
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>>FoodItemListNotFoundExResponseEntity(FoodItemListNotFound ex){
		ResponseStructure<String>structure=new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Fooditem List does not exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value() );
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}

	

}
