package com.sobis.carparking.service;

import java.util.List;

import com.sobis.carparking.model.Employee;
import com.sobis.carparking.model.File;

public interface EmployeeService {
	public void addEmployee(Employee employee);
	
	public Employee getEmployee(String employeeId);
	
	public List<Employee> getAllEmployees();		
	
	public File getImage(String employeeId);
	
	public Employee getEmployeeByUserName(String userName);
}
