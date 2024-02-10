package com.hotel.v2soru.dto;

import java.util.List;

import com.hotel.v2soru.entity.DeliveryBoy;
import com.hotel.v2soru.entity.Order;
import com.hotel.v2soru.entity.User;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AdminDto {
	private long adminId;
	private String adminName;
	private String adminEmail;
	private long adminContact;
	private List<User>user;
	private List<DeliveryBoy>deliveryboy;
	private List<Order>order;

}
