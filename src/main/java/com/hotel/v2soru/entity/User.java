package com.hotel.v2soru.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Entity
@Component
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@NotBlank(message="user name cannot be null")
	@NotNull(message="user name cannot be blank")
	private String userName;
	@NotBlank(message="user Email cannot be null")
	@NotNull(message="user Email cannot be null")
	@Email(message="Invalid Email",regexp="[A-Za-z0-9_.-]+@(.+)$")
	private String userEmail;
	@NotBlank(message="admin password cannot be null")
	@NotNull(message="admin password cannot be null")
	@Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)",
	message="password must bealphanumeric and special characters")
	@Size(min=6,max=10,message="password must be 6 to 10 characters")
	private String userPassword;
	@Positive
	private long userContact;
	@OneToMany (cascade = CascadeType.ALL)
	private List<FoodOrder>foodorder;
	@OneToOne
	private DeliveryBoy deliveryboy;
	
	

}
