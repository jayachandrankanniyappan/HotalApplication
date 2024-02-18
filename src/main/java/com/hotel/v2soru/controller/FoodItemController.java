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

import com.hotel.v2soru.entity.FoodItem;
import com.hotel.v2soru.service.FoodItemService;
import com.hotel.v2soru.util.ResponseStructure;

@RestController
@RequestMapping("Fooditem")
public class FoodItemController {
	@Autowired
	FoodItemService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<FoodItem>>saveFoodItem(@RequestBody FoodItem fooditem){
		return service.saveFoodItem(fooditem);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<FoodItem>>findFoodItem(@RequestParam int foodItemId){
		return service.findFoodItem(foodItemId);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<FoodItem>>deleteFoodItem(@RequestParam int foodItemId){
		return service.deleteFoodItem(foodItemId);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<FoodItem>>updateFoodItem(@RequestBody FoodItem fooditem,@RequestParam int foodItemId){
		return service.updateFoodItem(fooditem, foodItemId);
	}
	@GetMapping("findall")
	public ResponseEntity<ResponseStructure<List<FoodItem>>>findAllFoodItem(){
		return service.findAllFoodItem();
	}

}
