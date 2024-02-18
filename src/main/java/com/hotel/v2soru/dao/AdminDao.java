package com.hotel.v2soru.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.v2soru.entity.Admin;
import com.hotel.v2soru.repo.AdminRepo;
@Repository
public class AdminDao {
	@Autowired
	AdminRepo repo;
	
	public Admin saveAdmin(Admin admin) {
		return repo.save(admin);
	}
	
	public Admin findAdmin(int adminId) {
		Optional<Admin>opadmin=repo.findById(adminId);
		if(opadmin.isPresent()) {
			return opadmin.get();
		}
		return null;
	}
	
	public List<Admin>findAllAdmin(){
		return repo.findAll();
	}
	public Admin deleteAdmin(int adminId) {
		Admin admin=findAdmin(adminId);
		if(admin!=null) {
			repo.delete(admin);
			return admin;
		}
		return null;
	}
	
	public Admin updateAdmin(Admin admin,int  adminId) {
		Admin exadmin=findAdmin(adminId);
		if(exadmin!=null) {
			admin.setAdminId(adminId);
			repo.save(admin);
		}
		return null;
	}
	public Admin findByEmail(String adminEmail) {
		return repo.findByEmail(adminEmail);
	}
	
	

}
