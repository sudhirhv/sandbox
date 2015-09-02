package com.sobis.leave.service.security;

import com.sobis.leave.model.security.Role;

public interface RoleService {
	public Role getRole(String id);

	void addRole(Role r);
}
