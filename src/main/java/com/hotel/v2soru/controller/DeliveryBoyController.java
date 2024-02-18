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

import com.hotel.v2soru.entity.DeliveryBoy;
import com.hotel.v2soru.service.DeliveryBoyService;
import com.hotel.v2soru.util.ResponseStructure;

@RestController
@RequestMapping("DeliveryBoy")
public class DeliveryBoyController {
	@Autowired
	DeliveryBoyService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<DeliveryBoy>>saveDeliveryBoy(@RequestBody DeliveryBoy Deliveryboy){
		return service.saveDeliveryBoy(Deliveryboy);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<DeliveryBoy>>findDeliveryBoy(@RequestParam int deliveryboyId){
		return service.findDeliveryBoy(deliveryboyId);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<DeliveryBoy>>deleteDeliveryBoy(@RequestParam int deliveryboyId){
		return service.deleteDeliveryBoy(deliveryboyId);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<DeliveryBoy>>updateDeliveryBoy(@RequestBody DeliveryBoy deliveryboy,@RequestParam int deliveryboyId){
		return service.updateDeliveryBoy(deliveryboy, deliveryboyId);
	}
	@GetMapping("findall")
	public ResponseEntity<ResponseStructure<List<DeliveryBoy>>>findAllDeliveryBoy(){
		return service.findAllDeliveryBoy();
	}
	@PutMapping("assignDeliveryBoyToFoodOrder")
	public ResponseEntity<ResponseStructure<DeliveryBoy>>assignDeliveryBoyToFoodOrder(@RequestParam int deliveryboyId,@RequestParam int foodorderId){ 
		return service.assignDeliveryBoyToFoodOrder(deliveryboyId, foodorderId);
	}

}
