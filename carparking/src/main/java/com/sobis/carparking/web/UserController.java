package com.sobis.carparking.web;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sobis.carparking.model.Role;
import com.sobis.carparking.model.User;
import com.sobis.carparking.service.RoleService;
import com.sobis.carparking.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;	
	
	@Autowired
	private RoleService roleService;
	
	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Role.class, "roles", new CustomCollectionEditor(Set.class) {
					@Override
					protected Object convertElement(Object element) {												
						System.out.println("element val" + (String) element);
						if (element != null) {
							Role role = roleService.getRoleById((String) element);
							System.out.println("role name "	+ role.getRoleName());
							return role;
						} else
							return null;
					}
				});
    }
	
	@RequestMapping("/addUser.view")
	public @ResponseBody Map<String, Object> addEmployee(@ModelAttribute User user, BindingResult result, Model model) {		
		
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		jsonResponse.put("success", true);
		if(result.hasErrors()) {
			jsonResponse.put("success", false);
			jsonResponse.put("errors", result.getAllErrors());
		}
		System.out.println("username " +user.getUserName());
		userService.addUser(user);		
		return jsonResponse;
	}
	
	@RequestMapping("/addRole.view")
	public @ResponseBody Map<String, Object> addEmployee(@ModelAttribute Role role, BindingResult result) {		
		
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		jsonResponse.put("success", true);
		if(result.hasErrors()) {
			jsonResponse.put("success", false);
			jsonResponse.put("errors", result.getAllErrors());
		}
		
		roleService.addRole(role);		
		return jsonResponse;
	}
}
