package com.sobis.leave.dao;

import com.sobis.leave.model.security.User;

public interface UserContextDao {

	User getCurrentUser();
	void setCurrentUser(User user);
	
}
