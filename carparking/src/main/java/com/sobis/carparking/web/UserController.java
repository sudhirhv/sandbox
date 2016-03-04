package com.sobis.carparking.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
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
    protected void initBinder(WebDataBinder binder) {		
		binder.registerCustomEditor(Set.class, "roles", new CustomCollectionEditor(Set.class) {
			@Override
			protected Object convertElement(Object element) {												
				System.out.println("element val" + (String) element);
				if (element != null) {
					Role role = roleService.getRoleById((String) element);
					return role;
				} else
					return null;
			}
		});
    }
	
	@RequestMapping("/addUser.view")
	public @ResponseBody Map<String, Object> addUser(@ModelAttribute User user, BindingResult result, Model model) {		
		
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
	public @ResponseBody Map<String, Object> addRole(@ModelAttribute Role role, BindingResult result) {		
		
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
