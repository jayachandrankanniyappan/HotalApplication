package com.hotel.v2soru.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
@Component
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long adminId;
	private String adminName;
	private String adminEmail;
	private long adminContact;
	private String adminPassword;
	@OneToMany
	private List<User>user;
	@OneToMany
	private List<DeliveryBoy>deliveryboy;
	@OneToMany
	private List<Order>order;

}
