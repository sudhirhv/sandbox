package com.sobis.leave.service;

import java.util.List;

import com.sobis.leave.model.Employee;
import com.sobis.leave.model.EmployeeLeaveMaster;
import com.sobis.leave.model.Holiday;

public interface EmployeeService {
	
	public void addEmployee(Employee employee);
	
	public Employee getEmployeeById(String employeeId);
	
	public List<Employee> getAllEmployees();
	
	public Employee getApprover(String employeeId);
	
	public EmployeeLeaveMaster getEmployeeLeaveMaster(Employee employee, int leaveYear);

	public void addHoliday(Holiday holiday);	
	
	public List<Holiday> getHolidays();
}
