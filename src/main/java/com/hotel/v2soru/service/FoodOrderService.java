package com.hotel.v2soru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.v2soru.dao.FoodOrderDao;
import com.hotel.v2soru.entity.FoodOrder;
import com.hotel.v2soru.exception.FoodOrderListNotFound;
import com.hotel.v2soru.exception.FoodOrderNotFound;
import com.hotel.v2soru.util.ResponseStructure;

@Service  
public class FoodOrderService {
	@Autowired
	FoodOrderDao  fodao;
	
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


}
