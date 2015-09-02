package com.sobis.leave.web.editors;

import java.beans.PropertyEditorSupport;

import com.sobis.leave.model.security.Role;
import com.sobis.leave.service.security.RoleService;

public class UserEditor extends PropertyEditorSupport {
	
	private final RoleService roleService;
	 
    public UserEditor(RoleService roleService) {
        this.roleService = roleService;
    }
 
	public void setAsText(String roleId) throws IllegalArgumentException {
		System.out.println("in editor converting "+roleId);
		Role role = roleService.getRole(roleId);
		System.out.println("role "+role.getRole());
		setValue(role);
	}
	
}
