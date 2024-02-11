package com.hotel.v2soru.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.v2soru.entity.User;
import com.hotel.v2soru.repo.UserRepo;
@Repository
public class UserDao {
	 @Autowired
	 UserRepo repo;
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	public User findUser(int userId) {
		Optional<User>opuser=repo.findById(userId);
		if(opuser.isPresent()) {
			return opuser.get();
		}
		return null;
	}
	public User deleteUser(int userId) {
		User user=findUser(userId);
		if(user!=null) {
			repo.delete(user);
			return user;
		}
		return null;
	}
	
	public User updateUser(User user,int userId) {
		User exuser=findUser(userId);
		if(exuser!=null) {
			user.setUserId(userId);
			repo.save(user);
		}
		return null;
	}

}
