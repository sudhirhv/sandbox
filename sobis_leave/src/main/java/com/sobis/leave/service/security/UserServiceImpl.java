package com.sobis.leave.service.security;



import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sobis.leave.dao.security.RoleDao;
import com.sobis.leave.dao.security.UserDao;
import com.sobis.leave.model.security.Role;
import com.sobis.leave.model.security.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
    private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public User getUser(String username) {
		return userDao.getUser(username);
	}

	@Override	
	@Transactional(propagation=Propagation.REQUIRED)
	public void addUser(User u) {
		DateTime createdDate = new DateTime();	
		u.setCreatedOn(createdDate);
		u.setModifiedOn(createdDate);
		userDao.createUser(u);		
		
	}
	
	
}
