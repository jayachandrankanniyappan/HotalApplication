package com.hotel.v2soru.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.v2soru.entity.FoodOrder;
import com.hotel.v2soru.repo.FoodOrderRepo;
@Repository
public class FoodOrderDao {
	 @Autowired
	 FoodOrderRepo repo;
	
	public FoodOrder saveFoodOrder(FoodOrder foodorder) {
		return repo.save(foodorder);
	}
	
	public FoodOrder findFoodOrder(int foodorderId) {
		Optional<FoodOrder>opfoodorder=repo.findById(foodorderId);
		if(opfoodorder.isPresent()) {
			return opfoodorder.get();
		}
		return null;
	}
	public FoodOrder deleteFoodOrder(int foodorderId) {
		FoodOrder foodorder=findFoodOrder(foodorderId);
		if(foodorder!=null) {
			repo.delete(foodorder);
			return foodorder;
		}
		return null;
	}
	
	public FoodOrder updateFoodOrder(FoodOrder foodorder,int foodorderId) {
		FoodOrder exfoodorder=findFoodOrder(foodorderId);
		if(exfoodorder!=null) {
			foodorder.setFoodorderId(foodorderId);
			repo.save(foodorder);
		}
		return null;
	}
	public List<FoodOrder> findAllFoodOrder(){
		return repo.findAll();
	}

}
