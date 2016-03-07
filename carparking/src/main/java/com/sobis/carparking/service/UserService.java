package com.sobis.carparking.service;

import java.util.List;

import com.sobis.carparking.model.User;

public interface UserService {
	
	public void addUser(User user);

	public List<User> getAllUsers();

	public User getUserById(String userId);

	public User getUserByUserName(String userName);
	
}
