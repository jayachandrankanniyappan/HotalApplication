package com.hotel.v2soru.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.v2soru.dao.AdminDao;
import com.hotel.v2soru.dao.DeliveryBoyDao;
import com.hotel.v2soru.dao.FoodOrderDao;
import com.hotel.v2soru.dao.UserDao;
import com.hotel.v2soru.dto.AdminDto;
import com.hotel.v2soru.entity.Admin;
import com.hotel.v2soru.entity.DeliveryBoy;
import com.hotel.v2soru.entity.FoodOrder;
import com.hotel.v2soru.entity.OrderStatus;
import com.hotel.v2soru.entity.User;
import com.hotel.v2soru.exception.AdminListNotFound;
import com.hotel.v2soru.exception.AdminNotFound;
import com.hotel.v2soru.exception.DeliveryBoyNotFound;
import com.hotel.v2soru.exception.UserNotFound;
import com.hotel.v2soru.util.ResponseStructure;

@Service
public class AdminService {
	@Autowired
	AdminDao adao;
	@Autowired
	UserDao udao;
	@Autowired
	DeliveryBoyDao ddao;
	@Autowired
	FoodOrderDao fodao;
	
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
	
	public ResponseEntity<ResponseStructure<List<Admin>>>findAllAdmin(){
		List<Admin> adminlist=adao.findAllAdmin();
		if(!adminlist.isEmpty()) {
			ResponseStructure<List<Admin>>structure=new ResponseStructure<List<Admin>>();
			structure.setMessage("List of admin");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(adminlist);
			return new ResponseEntity<ResponseStructure<List<Admin>>>(structure,HttpStatus.FOUND);
		}
		throw new AdminListNotFound("Admin List not found");
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
	
	public ResponseEntity<ResponseStructure<Admin>>assignAdminToUser(int adminId,int userId){
		Admin admin=adao.findAdmin(adminId);
		User user=udao.findUser(userId);
		if(admin!=null) {
			if(user!=null) {
				admin.getUser().add(user);
				ResponseStructure<Admin>structure=new ResponseStructure<Admin>();
				structure.setMessage("assigned admin to user");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(adao.updateAdmin(admin, adminId));
				return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
			}
			throw new UserNotFound("user does not exist");
		}
		throw new UserNotFound("user does not exist");
	}
	
	public ResponseEntity<ResponseStructure<Admin>>assignAdminToDeliveryBoy(int adminId,int deliveryboyid){
		Admin admin=adao.findAdmin(adminId);
		DeliveryBoy deliveryboy=ddao.findDeliveryBoy(deliveryboyid);
		if(admin!=null) {
			if(deliveryboy!=null) {
				admin.getDeliveryboy().add(deliveryboy);
				ResponseStructure<Admin>structure=new ResponseStructure<Admin>();
				structure.setMessage("assigned admin to deliveryboy");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(adao.updateAdmin(admin, adminId));
				return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
			}
			throw new DeliveryBoyNotFound("deliveryboy does not exist");
		}
		throw new DeliveryBoyNotFound("deliveryboy does not exist");
	}
	
	public ResponseEntity<ResponseStructure<DeliveryBoy>>assignUserToDeliveryBoy(int userId,int deliveryboyId){
		User user=udao.findUser(userId);
		DeliveryBoy deliveryboy=ddao.findDeliveryBoy(deliveryboyId);
		if(user!=null) {
			if(deliveryboy!=null) {
				FoodOrder foodorder=fodao.findFoodOrder(userId) ;
				foodorder.setFoodorderitems(null);
				fodao.saveFoodOrder(foodorder);
				
				user.setDeliveryboy(deliveryboy);
				udao.updateUser(user, userId);
				ResponseStructure<DeliveryBoy>structure=new ResponseStructure<DeliveryBoy>();
				structure.setMessage("assigned admin to deliveryboy");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(ddao.updateDeliveryBoy(deliveryboy, deliveryboyId));
				return new ResponseEntity<ResponseStructure<DeliveryBoy>>(structure,HttpStatus.OK);	
			}
			throw new UserNotFound("user does not exist");
		}
		throw new UserNotFound("user does not exist");
	}
	public ResponseEntity<ResponseStructure<List<FoodOrder>>>OrderStatus(OrderStatus orderstatus){
		System.out.println(orderstatus);
		List<FoodOrder>allfoodorder=fodao.findAllFoodOrder();
		
		List<OrderStatus>allorderstatus=allfoodorder.stream()
				.map(FoodOrder :: getOrderstatus)
				.collect(Collectors.toList());
		List<FoodOrder>orders=null;
		System.out.println(allorderstatus);
		
		switch(orderstatus) {
		case ORDER_PROCESS:
			orders=allfoodorder.stream()
			.filter(order -> order.getOrderstatus() == OrderStatus.ORDER_PROCESS)
			.collect(Collectors.toList());
		System.out.println(orders);
		break;
		
		case ORDER_PENDING:
			orders=allfoodorder.stream()
			.filter(order -> order.getOrderstatus() == OrderStatus.ORDER_PENDING)
			.collect(Collectors.toList());
		System.out.println(orders);
		break;
		
		case ORDER_CANCLE:
			orders=allfoodorder.stream()
			.filter(order -> order.getOrderstatus() == OrderStatus.ORDER_CANCLE)
			.collect(Collectors.toList());
		System.out.println(orders);
		break;
		}
		ResponseStructure<List<FoodOrder>>structure=new ResponseStructure<List<FoodOrder>>();
		structure.setData(orders);
		structure.setMessage("all foodorder status");
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<FoodOrder>>>(structure,HttpStatus.OK);
	}

	
	public ResponseEntity<ResponseStructure<Admin>>LoginAdmin(String adminEmail){
		Admin byadminEmail=adao.findByEmail(adminEmail);
		if(byadminEmail!=null) {
			if(byadminEmail.getAdminEmail().equals(adminEmail)) {
				ResponseStructure<Admin>structure=new ResponseStructure<Admin>();
				structure.setMessage("Login sucessfully");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(byadminEmail);
				return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
			}
		}
		ResponseStructure<Admin>errorstructure=new ResponseStructure<Admin>();
		errorstructure.setMessage("Login failed");
		errorstructure.setStatus(HttpStatus.UNAUTHORIZED.value());
		return new ResponseEntity<ResponseStructure<Admin>>(errorstructure,HttpStatus.UNAUTHORIZED);
		
	}
	

}
