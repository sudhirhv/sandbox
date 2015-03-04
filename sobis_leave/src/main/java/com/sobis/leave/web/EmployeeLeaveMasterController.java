package com.sobis.leave.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sobis.leave.model.EmployeeLeaveMaster;
import com.sobis.leave.service.EmployeeLeaveMasterService;

@Controller
public class EmployeeLeaveMasterController {

	@Autowired
	private EmployeeLeaveMasterService employeeLeaveMasterService;
	
	@RequestMapping("/insertEmployeeLeaveMaster.view")
	public String addEmployee(@ModelAttribute("employeeLeaveMaster") EmployeeLeaveMaster elm, BindingResult errors, Model model) {
		employeeLeaveMasterService.addEmployeeLeaveMasterService(elm);
		//model.addAttribute("message", "Employee Leave master "+elm.getEmployee().getEmployeeName() + " added successfully");
		return "";
	}
}
