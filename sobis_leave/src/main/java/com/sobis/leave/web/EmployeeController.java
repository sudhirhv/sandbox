package com.sobis.leave.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sobis.leave.model.Employee;
import com.sobis.leave.model.Holiday;
import com.sobis.leave.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping("/addEmployee.view")
	public String getEmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "empAdd";
	}
			
	@RequestMapping("/insertEmployee.view")
	public String addEmployee(@ModelAttribute("employee") Employee e, BindingResult errors, Model model) {
		employeeService.addEmployee(e);
		model.addAttribute("message", "Employee "+e.getEmployeeName() + " added successfully");
		return "";
	}
	
	@RequestMapping("/insertHoliday.view")
	public String addEmployee(@ModelAttribute("holiday") Holiday h, BindingResult errors, Model model) {
		employeeService.addHoliday(h);
		model.addAttribute("message", "Holiday "+h.getHolidayName() + " added successfully");
		return "";
	}
	
	@RequestMapping("/home.view")
	public String getHomePage() {
		return "home";
	}
	
	@RequestMapping(value="/employeeLeaveDetails.view")
	public @ResponseBody Map<String, Object> getEmployees(@RequestParam("employeeId") String employeeId, @RequestParam("leaveYear") int leaveYear) {
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		Map<String, Object> employeeLeaveDetails = new HashMap<String, Object>();
		
		Employee employee = employeeService.getEmployeeById(employeeId);
		employeeLeaveDetails.put("manager", employeeService.getApprover(employeeId).getId());
		employeeLeaveDetails.put("availableLeaveBalance", employeeService.getEmployeeLeaveMaster(employee, leaveYear).getAvailableLeaveBalance());
		
		jsonResponse.put("success", true);
		jsonResponse.put("rows", employeeLeaveDetails);
		return jsonResponse;
	}
}
