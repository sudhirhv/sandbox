package com.sobis.leave.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sobis.leave.model.Employee;
import com.sobis.leave.service.EmployeeService;
import com.sobis.leave.service.LeaveRequestService;


@Controller
public class LeaveRequestController {

	@Autowired
	private LeaveRequestService leaveRequestService;
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@ModelAttribute("employees")
	public List<Employee> getEmployees() {
		//return leaveRequestService.getAllEmployees();
		return null;
	}
	
	@ModelAttribute("availableLeaveBalance")
	public int getAvailableLeaveBalance(int employeeId, int leaveYear) {		
		return employeeService.getAvailableLeaveBalance(employeeId, leaveYear);
	}
	
	@ModelAttribute("approver")
	public Employee getApprover(int employeeId) {		
		return employeeService.getApprover(employeeId);
	}
}
