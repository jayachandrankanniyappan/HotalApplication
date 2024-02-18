package com.hotel.v2soru.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hotel.v2soru.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	@Query("select u from User u where u.userEmail = :userEmail")
	User findByEmail(@Param("userEmail")  String userEmail);

}
