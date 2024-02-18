package com.hotel.v2soru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.v2soru.entity.FoodOrder;
import com.hotel.v2soru.service.FoodOrderService;
import com.hotel.v2soru.util.ResponseStructure;

@RestController
@RequestMapping("FoodOrder")
public class FoodOrderController {
	@Autowired
	FoodOrderService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<FoodOrder>>saveFoodOrder(@RequestBody FoodOrder foodorder){
		return service.saveFoodOrder(foodorder);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<FoodOrder>>findFoodOrder(@RequestParam int foodorderId){
		return service.findFoodOrder(foodorderId);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<FoodOrder>>deleteFoodOrder(@RequestParam int foodorderId){
		return service.deleteFoodOrder(foodorderId);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<FoodOrder>>updateFoodOrder(@RequestBody FoodOrder foodorder,@RequestParam int foodorderId){
		return service.updateFoodOrder(foodorder, foodorderId);
	}
	@GetMapping("findall")
	public ResponseEntity<ResponseStructure<List<FoodOrder>>>findAllFoodOrder(){
		return service.findAllFoodOrder();
	}
	@PutMapping("assignFoodOrderToFoodItem")
	public ResponseEntity<ResponseStructure<FoodOrder>>assignFoodOrderToFoodItem(@RequestParam int foodorderId,@RequestParam int foodItemId){
		return service.assignFoodOrderToFoodItem(foodorderId, foodItemId);
	}
	@PutMapping("removefooditem")
	public ResponseEntity<ResponseStructure<FoodOrder>>removeFoodOrder(@RequestParam int foodorderId,@RequestParam int foodItemId){
		return service.removeFoodOrder(foodorderId, foodItemId);
	}


}
