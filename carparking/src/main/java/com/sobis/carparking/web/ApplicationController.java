package com.sobis.carparking.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sobis.carparking.model.Employee;
import com.sobis.carparking.service.EmployeeService;

@Controller
public class ApplicationController {

	static final Logger logger = LogManager.getLogger(ApplicationController.class.getName());
	
	@Autowired	
	private EmployeeService employeeService;
	
	@RequestMapping("/applicationController.do")
	public @ResponseBody Map<String, Object> getLogin() {
		logger.debug("Application controller init");
		Map<String, Object> jsonResponse = new HashMap<String, Object>();		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
		try {
			Employee employee = employeeService.getEmployeeByUserName(name);
			jsonResponse.put("success", true);		
			jsonResponse.put("userName", name);	
			jsonResponse.put("employee", employee);
			logger.debug("Getting employee details "+employee.getEmployeeName());
		} catch (Exception e) {
			logger.error("error occured",e);
		}
		
		return jsonResponse;	
	}


}
