package com.hotel.v2soru.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hotel.v2soru.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
	 @Query("select a from Admin a where a.adminEmail= :adminEmail")
	 Admin findByEmail(@Param("adminEmail") String adminEmail);

}
