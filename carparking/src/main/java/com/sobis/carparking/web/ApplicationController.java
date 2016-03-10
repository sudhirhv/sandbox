package com.sobis.carparking.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sobis.carparking.service.EmployeeService;

@Controller
public class ApplicationController {

	@Autowired	
	private EmployeeService employeeService;
	
	@RequestMapping("/applicationController.do")
	public @ResponseBody Map<String, Object> getLogin() {
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
		
		jsonResponse.put("success", true);		
		jsonResponse.put("userName", name);	
		jsonResponse.put("employee", employeeService.getEmployeeByUserName(name));
		return jsonResponse;	
	}


}
