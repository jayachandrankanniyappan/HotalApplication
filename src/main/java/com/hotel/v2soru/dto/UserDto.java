package com.hotel.v2soru.dto;

import java.util.List;

import com.hotel.v2soru.entity.FoodOrder;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserDto {
	private long userId;
	private String userName;
	private String userEmail;
	private long userContact;
	private List<FoodOrder>orders;

}
