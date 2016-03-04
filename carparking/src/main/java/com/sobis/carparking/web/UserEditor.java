package com.sobis.carparking.web;

import java.beans.PropertyEditorSupport;

import com.sobis.carparking.model.Role;
import com.sobis.carparking.service.RoleService;

public class UserEditor extends PropertyEditorSupport {
	
	  private final RoleService roleService;   
	  
	  
      protected Object convertElement(Object element) {
      	System.out.println("element val"+(String) element);  
      	return (element == null) ? null: roleService.getRoleById((String) element);     
      }
	    
	    public UserEditor(RoleService roleService) {
	        this.roleService = roleService;
	    }
	 
		/*public void setAsText(String roleId) throws IllegalArgumentException {			
			Role role = roleService.getRoleById(roleId);			
			setValue(role);
		}*/	
}
