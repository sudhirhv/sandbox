package com.sobis.leave.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sobis.leave.model.Employee;
import com.sobis.leave.service.EmployeeLeaveMasterService;
import com.sobis.leave.service.EmployeeService;
import com.sobis.leave.service.LeaveRequestService;



@Controller
public class LeaveRequestController {

	@Autowired
	private LeaveRequestService leaveRequestService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeLeaveMasterService employeeLeaveMasterService;
	
	
	/*@ModelAttribute("employees")
	public List<Employee> getEmployees() {
		//return leaveRequestService.getAllEmployees();
		return null;
	}*/
	
/*	@ModelAttribute("availableLeaveBalance")
	public int getAvailableLeaveBalance(String employeeId, int leaveYear) {		
		return employeeLeaveMasterService.getAvailableLeaveBalance(employeeId, leaveYear);
	}
	
	@ModelAttribute("approver")
	public Employee getApprover(String employeeId) {		
		return employeeService.getApprover(employeeId);
	}*/
	
	@RequestMapping(value="/employees.view")
	public @ResponseBody Map<String, Object> getEmployees() {
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		jsonResponse.put("success", true);
		jsonResponse.put("rows", employeeService.getAllEmployees());
		return jsonResponse;
	}
	
}
