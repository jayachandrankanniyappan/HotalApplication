package com.hotel.v2soru.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.v2soru.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

}
