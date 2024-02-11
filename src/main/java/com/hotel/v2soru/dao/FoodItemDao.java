package com.hotel.v2soru.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.v2soru.entity.FoodItem;
import com.hotel.v2soru.repo.FoodItemRepo;
@Repository
public class FoodItemDao {
	 @Autowired
	 FoodItemRepo repo;
	
	public FoodItem saveFoodItem(FoodItem fooditem) {
		return repo.save(fooditem);
	}
	
	public FoodItem findFoodItem(int foodItemId) {
		Optional<FoodItem>opfooditem=repo.findById(foodItemId);
		if(opfooditem.isPresent()) {
			return opfooditem.get();
		}
		return null;
	}
	public FoodItem deleteFoodItem(int foodItemId) {
		FoodItem fooditem=findFoodItem(foodItemId);
		if(fooditem!=null) {
			repo.delete(fooditem);
			return fooditem;
		}
		return null;
	}
	
	public FoodItem updateFoodItem(FoodItem fooditem,int foodItemId) {
		FoodItem exfooditem=findFoodItem(foodItemId);
		if(exfooditem!=null) {
			fooditem.setFoodItemId(foodItemId);
			repo.save(fooditem);
		}
		return null;
	}
	public List<FoodItem> findAllFoodItem(){
		return repo.findAll();
	}

}
