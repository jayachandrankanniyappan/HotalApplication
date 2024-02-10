package com.hotel.v2soru.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.v2soru.entity.FoodItem;

public interface FoodItemRepo extends JpaRepository<FoodItem, Integer>{

}
