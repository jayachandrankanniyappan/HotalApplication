package com.hotel.v2soru.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	@OneToMany(cascade = CascadeType.ALL )
	private List<FoodOrder>foodorders;
	@JsonIgnore 
	@OneToOne
	private User user;

}
