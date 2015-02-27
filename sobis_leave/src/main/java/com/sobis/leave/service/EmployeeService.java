package com.sobis.leave.service;

import java.util.List;

import com.sobis.leave.model.Employee;
import com.sobis.leave.model.EmployeeLeaveMaster;

public interface EmployeeService {
	
	public void addEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public int getAvailableLeaveBalance(int employeeId, int leaveYear);
	
	public Employee getApprover(int employeeId);
	
	public EmployeeLeaveMaster getEmployeeLeaveMaster(Employee employee, int leaveYear);
	
}
