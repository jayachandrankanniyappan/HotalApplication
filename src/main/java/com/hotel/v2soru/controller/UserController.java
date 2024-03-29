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

import com.hotel.v2soru.dto.UserDto;
import com.hotel.v2soru.entity.User;
import com.hotel.v2soru.service.UserService;
import com.hotel.v2soru.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("User")
public class UserController {
	@Autowired
	UserService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<UserDto>>saveUser(@Valid @RequestBody User user,BindingResult result){
		return service.saveUser(user);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<User>>findUser(@RequestParam int userId){
		return service.findUser(userId);
	}
	@GetMapping("findall")
	public ResponseEntity<ResponseStructure<List<User>>>findAllUser(){
		return service.findAllUser();
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<User>>deleteUser(@RequestParam int userId){
		return service.deleteUser(userId);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<User>>updateUser(@RequestBody User user,@RequestParam int userId){
		return service.updateUser(user, userId);
	}
	@PutMapping("assignUserToFoodOrder")
	public ResponseEntity<ResponseStructure<User>>assignUserToFoodOrder(@RequestParam int userId,@RequestParam int foodorderId){
		return service.assignUserToFoodOrder(userId, foodorderId);
	}
	@PostMapping("login")
	public ResponseEntity<ResponseStructure<User>>LoginUser(@RequestParam String userEmail){
		return service.LoginUser(userEmail);
	}

}
