package com.sobis.leave.dao.security;

import com.sobis.leave.model.security.Role;

public interface RoleDao {

	public Role getRole(String string);

	public void createRole(Role r);
}
