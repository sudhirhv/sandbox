package com.sobis.carparking.dao;

import java.util.List;

import com.sobis.carparking.model.Role;
import com.sobis.carparking.model.User;

public interface RoleDao {

	public void addRole(Role role);
	
	public List<Role> getAllRoles();
	
	public Role getRoleById(String roleId);
	
	public List<User> getAllUsersForRole(Role role);

	
}
