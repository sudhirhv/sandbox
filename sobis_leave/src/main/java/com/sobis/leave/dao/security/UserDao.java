package com.sobis.leave.dao.security;

import java.util.List;

import com.sobis.leave.model.security.User;

public interface UserDao {

	public void createUser(User user);
	
	public User getUser(String userId);
	
	public List<User> getAllUsers();
		
	
}
