package com.hotel.v2soru.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.v2soru.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
