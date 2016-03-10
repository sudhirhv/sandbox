package com.sobis.carparking.web;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sobis.carparking.model.Employee;
import com.sobis.carparking.service.EmployeeService;
import com.sobis.carparking.service.FileService;


@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired 
	private FileService fileService;
	
	
	
	@RequestMapping("/addEmployee.do")
	public @ResponseBody Map<String, Object> addEmployee(@ModelAttribute Employee employee, BindingResult result) {		
		
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		jsonResponse.put("success", true);
		if(result.hasErrors()) {
			jsonResponse.put("success", false);
			jsonResponse.put("errors", result.getAllErrors());
		}
		System.out.println("name - "+employee.getEmployeeName());
		employeeService.addEmployee(employee);
		System.out.println(jsonResponse.get("success"));
		return jsonResponse;
	}
	
	@RequestMapping("/getEmployeeByUserName.do")
	public @ResponseBody Map<String, Object> getEmployeeByUserName(String userName) {		
		System.out.println("userName - "+userName);
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		jsonResponse.put("success", true);
		/*if(result.hasErrors()) {
			jsonResponse.put("success", false);
			jsonResponse.put("errors", result.getAllErrors());
		}*/
	
		jsonResponse.put("user", userName);
		jsonResponse.put("employee", employeeService.getEmployeeByUserName(userName));		
		return jsonResponse;
	}
	
	/*@RequestMapping(value = "/addFile.view", method = RequestMethod.POST)
	public String uploadFile(@ModelAttribute File file, BindingResult result, ModelMap model) throws IllegalStateException, IOException {
		  MultipartFile multipartFile = file.getFile();
		  
          // Now do something with file...
          FileCopyUtils.copy(file.getFile().getBytes(), new java.io.File( "e:/" + file.getFile().getOriginalFilename()));
          String fileName = multipartFile.getOriginalFilename();
          model.addAttribute("fileName", fileName);
		return "success";
    }*/
	
	
	
}
