package com.hotel.v2soru.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.v2soru.dto.AdminDto;
import com.hotel.v2soru.entity.Admin;
import com.hotel.v2soru.entity.DeliveryBoy;
import com.hotel.v2soru.entity.FoodOrder;
import com.hotel.v2soru.service.AdminService;
import com.hotel.v2soru.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("Admin")
public class AdminController {
	@Autowired
	AdminService service;
	@PostMapping
	public ResponseEntity<ResponseStructure<AdminDto>>saveAdmin(@Valid @RequestBody Admin admin,BindingResult result ){
		return service.saveAdmin(admin);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Admin>>findAdmin(@RequestParam int adminId){
		return service.findAdmin(adminId);
	}
	@GetMapping("findall")
	public ResponseEntity<ResponseStructure<List<Admin>>>findAllAdmin(){
		return service.findAllAdmin();
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Admin>>deleteAdmin(@RequestParam int adminId){
		return service.deleteAdmin(adminId);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Admin>>updateAdmin(@RequestBody Admin admin,@RequestParam int adminId){
		return service.updateAdmin(admin, adminId);
	}
	@PutMapping("assignAdminToUser")
	public ResponseEntity<ResponseStructure<Admin>>assignAdminToUser(@RequestParam int adminId,@RequestParam int userId){
		return service.assignAdminToUser(adminId, userId);
	}
	@PutMapping("assignAdminToDeliveryBoy")
	public ResponseEntity<ResponseStructure<Admin>>assignAdminToDeliveryBoy(@RequestParam int adminId,@RequestParam int deliveryboyId){
		return service.assignAdminToDeliveryBoy(adminId, deliveryboyId);
	}
	@PutMapping("assignUserToDeliveryBoy")
	public ResponseEntity<ResponseStructure<DeliveryBoy>>assignUserToDeliveryBoy(@RequestParam int userId,@RequestParam int deliveryboyId){
		return service.assignUserToDeliveryBoy(userId, deliveryboyId);
	}
	@GetMapping("OrderStatus")
	public ResponseEntity<ResponseStructure<List<FoodOrder>>>OrderStatus(@RequestParam com.hotel.v2soru.entity.OrderStatus orderstatus){
		return service.OrderStatus(orderstatus);
	}
	
	@PostMapping("login")
	public ResponseEntity<ResponseStructure<Admin>>LoginAdmin(@RequestParam String adminEmail){
		return service.LoginAdmin(adminEmail);
	}

}
