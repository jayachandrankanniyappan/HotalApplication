package com.hotel.v2soru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.v2soru.dao.FoodItemDao;
import com.hotel.v2soru.entity.FoodItem;
import com.hotel.v2soru.exception.FoodItemListNotFound;
import com.hotel.v2soru.exception.FoodItemNotFound;
import com.hotel.v2soru.util.ResponseStructure;

@Service
public class FoodItemService {
	@Autowired
	FoodItemDao fidao;
	
	public ResponseEntity<ResponseStructure<FoodItem>> saveFoodItem(FoodItem fooditem) {
		ResponseStructure<FoodItem>structure=new ResponseStructure<FoodItem>();
		structure.setMessage("FoodItem save sucess");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(fidao.saveFoodItem(fooditem));
		return new ResponseEntity<ResponseStructure<FoodItem>>(structure,HttpStatus.CREATED);

	}
	
	public ResponseEntity<ResponseStructure<FoodItem>> findFoodItem(int foodItemId) {
		FoodItem fooditem=fidao.findFoodItem(foodItemId);
		if(fooditem!=null) {
			ResponseStructure<FoodItem>structure=new ResponseStructure<FoodItem>();
			structure.setMessage("FoodItem Found ");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(fooditem);
			return new ResponseEntity<ResponseStructure<FoodItem>>(structure,HttpStatus.FOUND);	
		}
		throw new FoodItemNotFound("foodItem not found in the given id");
	}
	public ResponseEntity<ResponseStructure<FoodItem>> deleteFoodItem(int foodItemId) {
		FoodItem fooditem=fidao.findFoodItem(foodItemId);
		if(fooditem!=null) {
			ResponseStructure<FoodItem>structure=new ResponseStructure<FoodItem>();
			structure.setMessage("FoodItem delete sucess");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(fidao.deleteFoodItem(foodItemId));
			return new ResponseEntity<ResponseStructure<FoodItem>>(structure,HttpStatus.OK);
		}
		throw new FoodItemNotFound("foodItem not found in the given id");
	}
	public ResponseEntity<ResponseStructure<FoodItem>> updateFoodItem(FoodItem fooditem,int foodItemId) {
		ResponseStructure<FoodItem>structure=new ResponseStructure<FoodItem>();
		structure.setMessage("FoodItem update sucess");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(fidao.updateFoodItem(fooditem, foodItemId));
		return new ResponseEntity<ResponseStructure<FoodItem>>(structure,HttpStatus.OK);

	}
	
	public ResponseEntity<ResponseStructure<List<FoodItem>>>findAllFoodItem(){
		ResponseStructure<List<FoodItem>>structure=new ResponseStructure<List<FoodItem>>();
		List<FoodItem>fooditem=fidao.findAllFoodItem();
		if(!fooditem.isEmpty()) {
			structure.setMessage("List of fooditems");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(fooditem);
			return new ResponseEntity<ResponseStructure<List<FoodItem>>>(structure,HttpStatus.FOUND);
		}
		throw new  FoodItemListNotFound("FoodItem List not found"); 
	}


}
