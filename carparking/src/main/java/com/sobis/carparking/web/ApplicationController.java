package com.sobis.carparking.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApplicationController {

	@RequestMapping("/applicationController.view")

	public @ResponseBody Map<String, Object> getLogin() {
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username		
		jsonResponse.put("success", true);		
		jsonResponse.put("userName", name);			
		return jsonResponse;		

	}


}
