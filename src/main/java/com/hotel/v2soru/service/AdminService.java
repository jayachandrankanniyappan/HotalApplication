package com.hotel.v2soru.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.v2soru.dao.AdminDao;
import com.hotel.v2soru.dto.AdminDto;
import com.hotel.v2soru.entity.Admin;
import com.hotel.v2soru.exception.AdminNotFound;
import com.hotel.v2soru.util.ResponseStructure;

@Service
public class AdminService {
	@Autowired
	AdminDao adao;
	
	public ResponseEntity<ResponseStructure<AdminDto>>saveAdmin(Admin admin){
		AdminDto dto=new AdminDto();
		ModelMapper mapper=new ModelMapper();
		mapper.map(adao.saveAdmin(admin), dto);
		ResponseStructure<AdminDto>structure=new ResponseStructure<AdminDto>();
		structure.setMessage("admin save sucess");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dto);
		return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.CREATED); 
	}
	
	public ResponseEntity<ResponseStructure<Admin>>findAdmin(int adminId){
		Admin admin=adao.findAdmin(adminId);
		if(admin!=null) {
			ResponseStructure<Admin>structure=new ResponseStructure<Admin>();
			structure.setMessage("admin found ");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(admin);
			return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.FOUND); 
		}
		throw new  AdminNotFound("Admin not found in the given id");
	}
	
	public ResponseEntity<ResponseStructure<Admin>>deleteAdmin(int adminId){
		Admin admin=adao.findAdmin(adminId);
		if(admin!=null) {
			ResponseStructure<Admin>structure=new ResponseStructure<Admin>();
			structure.setMessage("admin delete sucess");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(adao.deleteAdmin(adminId));
			return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK); 
		}
		throw new  AdminNotFound("Admin not found in the given id");
	}
	
	public ResponseEntity<ResponseStructure<Admin>>updateAdmin(Admin admin,int adminId){
		ResponseStructure<Admin>structure=new ResponseStructure<Admin>();
		structure.setMessage("admin update sucess");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(adao.updateAdmin(admin, adminId));
		return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
	}

}
