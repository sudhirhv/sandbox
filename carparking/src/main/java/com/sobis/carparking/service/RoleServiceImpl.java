package com.sobis.carparking.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sobis.carparking.dao.RoleDao;
import com.sobis.carparking.model.Role;

@Service
@EnableTransactionManagement
public class RoleServiceImpl implements RoleService {

	
	@Autowired
	private RoleDao roleDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addRole(Role role) {
		Date createdDate = new Date();
		role.setCreatedOn(createdDate);
		role.setModifiedOn(createdDate);
		roleDao.addRole(role);
	}

	@Override
	public Role getRoleById(String roleId) {
		return roleDao.getRoleById(roleId);
	}
	

}
