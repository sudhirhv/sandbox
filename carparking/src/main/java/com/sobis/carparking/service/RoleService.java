package com.sobis.carparking.service;

import com.sobis.carparking.model.Role;

public interface RoleService {
	
	public void addRole(Role role);
	
	public Role getRoleById(String roleId);
	
	
}
