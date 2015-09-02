package com.sobis.leave.web.security;

import java.util.HashMap;
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

import com.sobis.leave.model.security.Role;
import com.sobis.leave.model.security.User;
import com.sobis.leave.service.security.RoleService;
import com.sobis.leave.service.security.UserService;
import com.sobis.leave.web.editors.UserEditor;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		System.out.println("params "+request.getParameter("roles"));
		/*binder.registerCustomEditor(User.class, "roles", new UserEditor(roleService));
		System.out.println("user editor registered");*/
		
		binder.registerCustomEditor(Role.class, "roles", new CustomCollectionEditor(Set.class) {
            @Override
            protected Object convertElement(Object element) {
            	  System.out.println("element val"+(String) element);  
                  if (element != null) {
                	  Role role = roleService.getRole((String) element);
                	  System.out.println("role name "+role.getRole());
                	  return role;
                  } else return null;      
            }
		});		
    }
	
	@RequestMapping("/insertUser.view")	
	public @ResponseBody Map<String, Object> addUser(@ModelAttribute User u, BindingResult errors, Model model) {
		
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		jsonResponse.put("success", true);
		if(errors.hasErrors()) {
			jsonResponse.put("success", false);
			jsonResponse.put("errors", errors.getAllErrors());
		}
		userService.addUser(u);		
		return jsonResponse;
	}
	
	@RequestMapping("/insertRole.view")
	public @ResponseBody Map<String, Object> addRole(@ModelAttribute Role r, BindingResult errors, Model model) {		
		
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		jsonResponse.put("success", true);
		if(errors.hasErrors()) {
			jsonResponse.put("success", false);
			jsonResponse.put("errors", errors.getAllErrors());
		}
		roleService.addRole(r);		
		return jsonResponse;
	}
}
