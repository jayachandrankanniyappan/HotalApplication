package com.hotel.v2soru.controller;

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

import com.hotel.v2soru.dto.AdminDto;
import com.hotel.v2soru.entity.Admin;
import com.hotel.v2soru.service.AdminService;
import com.hotel.v2soru.util.ResponseStructure;

@RestController
@RequestMapping("Admin")
public class AdminController {
	@Autowired
	AdminService service;
	@PostMapping
	public ResponseEntity<ResponseStructure<AdminDto>>saveAdmin(@RequestBody Admin admin){
		return service.saveAdmin(admin);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Admin>>findAdmin(@RequestParam int adminId){
		return service.findAdmin(adminId);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Admin>>deleteAdmin(@RequestParam int adminId){
		return service.deleteAdmin(adminId);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Admin>>updateAdmin(@RequestBody Admin admin,@RequestParam int adminId){
		return service.updateAdmin(admin, adminId);
	}

}
