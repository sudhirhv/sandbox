package com.sobis.leave.service.security;

import com.sobis.leave.model.security.User;

public interface UserService {
	
	public User getUser(String username);

	public void addUser(User u);
	
}
