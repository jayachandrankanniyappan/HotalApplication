package com.hotel.v2soru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.v2soru.dao.FoodItemDao;
import com.hotel.v2soru.dao.FoodOrderDao;
import com.hotel.v2soru.entity.FoodItem;
import com.hotel.v2soru.entity.FoodOrder;
import com.hotel.v2soru.exception.FoodItemNotFound;
import com.hotel.v2soru.exception.FoodOrderListNotFound;
import com.hotel.v2soru.exception.FoodOrderNotFound;
import com.hotel.v2soru.util.ResponseStructure;

@Service  
public class FoodOrderService {
	@Autowired
	FoodOrderDao  fodao;
	
	@Autowired
	FoodItemDao fidao;
	
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodorder) {
		ResponseStructure<FoodOrder>structure=new ResponseStructure<FoodOrder>();
		structure.setMessage("Foodorder save sucess");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(fodao.saveFoodOrder(foodorder));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(structure,HttpStatus.CREATED);

	}
	
	public ResponseEntity<ResponseStructure<FoodOrder>> findFoodOrder(int foodorderId) {
		FoodOrder foodorder=fodao.findFoodOrder(foodorderId);
		if(foodorder!=null) {
			ResponseStructure<FoodOrder>structure=new ResponseStructure<FoodOrder>();
			structure.setMessage("FoodOrder Found ");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(foodorder);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(structure,HttpStatus.FOUND);	
		}
		throw new FoodOrderNotFound("FoodOrder not found in the given id");
	}
	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(int foodorderId) {
		FoodOrder foodorder=fodao.deleteFoodOrder(foodorderId);
		if(foodorder!=null) {
			ResponseStructure<FoodOrder>structure=new ResponseStructure<FoodOrder>();
			structure.setMessage("FoodOrder delete sucess");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(fodao.deleteFoodOrder(foodorderId));
			return new ResponseEntity<ResponseStructure<FoodOrder>>(structure,HttpStatus.OK);
		}
		throw new FoodOrderNotFound("FoodOrder not found in the given id");
	}
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(FoodOrder foodorder,int foodorderId) {
		ResponseStructure<FoodOrder>structure=new ResponseStructure<FoodOrder>();
		structure.setMessage("FoodOrder update sucess");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(fodao.updateFoodOrder(foodorder, foodorderId));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(structure,HttpStatus.OK);

	}
	
	public ResponseEntity<ResponseStructure<List<FoodOrder>>>findAllFoodOrder(){
		ResponseStructure<List<FoodOrder>>structure=new ResponseStructure<List<FoodOrder>>();
		List<FoodOrder>foodorder=fodao.findAllFoodOrder();
		if(!foodorder.isEmpty()) {
			structure.setMessage("List of FoodOrder");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(foodorder);
			return new ResponseEntity<ResponseStructure<List<FoodOrder>>>(structure,HttpStatus.FOUND);
		}
		throw new FoodOrderListNotFound("FoodOrder List not Found");
	}
	
	public ResponseEntity<ResponseStructure<FoodOrder>>assignFoodOrderToFoodItem(int foodorderId,int foodItemId){
		FoodOrder foodorder=fodao.findFoodOrder(foodorderId);
		FoodItem fooditem=fidao.findFoodItem(foodItemId);
		if(foodorder!=null) {
			if(fooditem!=null) {
				List<FoodItem>items= foodorder.getFoodorderitems();
				items.add(fooditem);
				long totalcost=calculateTotalCost(items);
				
				foodorder.setTotalcost(totalcost);
				foodorder.setFoodorderitems(items);
				
				FoodOrder updatefoodorder=fodao.updateFoodOrder(foodorder, foodorderId);
				ResponseStructure<FoodOrder>structure=new ResponseStructure<FoodOrder>();
				structure.setMessage("assigned foodorder to fooditems");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(updatefoodorder);
				return new ResponseEntity<ResponseStructure<FoodOrder>>(structure,HttpStatus.OK);
			}
			throw new FoodItemNotFound("food item not found");
		}
		throw new FoodItemNotFound("food item not found");
	}
	
	private long calculateTotalCost(List<FoodItem>items) {
		long totalcost=0;
		for(FoodItem item : items) {
			totalcost +=item.getFoodItemcostperitem();
		}
		return totalcost;
	}
	
	public ResponseEntity<ResponseStructure<FoodOrder>>removeFoodOrder(int foodorderId,int foodItemId){
		FoodOrder foodorder=fodao.findFoodOrder(foodorderId);
		FoodItem fooditem=fidao.findFoodItem(foodItemId);
		if(foodorder!=null) {
			if(fooditem!=null) {
				List<FoodItem>items= foodorder.getFoodorderitems();
				items.remove(fooditem);
				foodorder.setFoodorderitems(items);
				long totalcost=reduceTotalCost(items);
				
				foodorder.setTotalcost(totalcost);
				
				FoodOrder updatefoodorder=fodao.saveFoodOrder(foodorder);
				ResponseStructure<FoodOrder>structure=new ResponseStructure<FoodOrder>();
				structure.setMessage("fooditems removed");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(updatefoodorder);
				return new ResponseEntity<ResponseStructure<FoodOrder>>(structure,HttpStatus.OK);
			}
			throw new FoodItemNotFound("food item does not exist");
		}
		throw new FoodItemNotFound("food item does not exist");
	}
	
	private long reduceTotalCost(List<FoodItem>items) {
		long totalcost=0;
		for(FoodItem item : items) {
			totalcost +=item.getFoodItemcostperitem();
		}
		return totalcost;
	}


}
