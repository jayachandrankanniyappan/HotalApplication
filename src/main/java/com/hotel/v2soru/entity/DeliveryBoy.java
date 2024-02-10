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
@Component
@Data
public class DeliveryBoy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deliveryboyId;
	private String deliveryboyName;
	private long deliveryboyContact;
	@OneToMany
	private List<Order>orders;

}
