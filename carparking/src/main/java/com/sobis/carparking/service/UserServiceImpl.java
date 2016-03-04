package com.sobis.carparking.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sobis.carparking.dao.RoleDao;
import com.sobis.carparking.dao.UserDao;
import com.sobis.carparking.model.User;

@Service
@EnableTransactionManagement
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addUser(User user) {
		Date createdDate = new Date();
		
		user.setCreatedOn(createdDate);
		user.setModifiedOn(createdDate);			
		userDao.addUser(user);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<User> getAllUsers() {		
		return userDao.getAllUsers();
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public User getUserById(String userId) {
		return userDao.getUserById(userId);
	}

}
