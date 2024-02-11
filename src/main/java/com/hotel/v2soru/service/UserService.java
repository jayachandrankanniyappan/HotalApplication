package com.hotel.v2soru.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.v2soru.dao.UserDao;
import com.hotel.v2soru.dto.UserDto;
import com.hotel.v2soru.entity.User;
import com.hotel.v2soru.exception.UserNotFound;
import com.hotel.v2soru.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	UserDao udao;
	
	public ResponseEntity<ResponseStructure<UserDto>>saveUser(User user){
		UserDto dto=new UserDto();
		ModelMapper mapper=new ModelMapper();
		mapper.map(udao.saveUser(user), dto);
		ResponseStructure<UserDto>structure=new ResponseStructure<UserDto>();
		structure.setMessage("user save sucess");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dto);
		return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.CREATED); 
	}
	
	public ResponseEntity<ResponseStructure<User>>findUser(int userId){
		User user=udao.findUser(userId);
		if(user!=null) {
			ResponseStructure<User>structure=new ResponseStructure<User>();
			structure.setMessage("user found ");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND); 
		}
		throw new UserNotFound("user not found in the given id");
	}
	
	public ResponseEntity<ResponseStructure<User>>deleteUser(int userId){
		User user=udao.findUser(userId);
		if(user!=null) {
			ResponseStructure<User>structure=new ResponseStructure<User>();
			structure.setMessage("user delete sucess");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(udao.deleteUser(userId));
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK); 
		}
		throw new UserNotFound("user not found in the given id");
	}
	
	public ResponseEntity<ResponseStructure<User>>updateUser(User user,int userId){
		ResponseStructure<User>structure=new ResponseStructure<User>();
		structure.setMessage("user update sucess");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(udao.updateUser(user, userId));
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
	}

}
