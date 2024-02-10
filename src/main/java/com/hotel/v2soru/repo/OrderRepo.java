package com.hotel.v2soru.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.v2soru.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
