package com.sobis.carparking.dao;

import java.util.List;

import com.sobis.carparking.model.User;

public interface UserDao {

	public void addUser(User user);
	
	public List<User> getAllUsers();
	
	public User getUserById(String userId);

	
}
