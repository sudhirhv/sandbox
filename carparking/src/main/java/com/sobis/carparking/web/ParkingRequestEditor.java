package com.sobis.carparking.web;

import java.beans.PropertyEditorSupport;

import com.sobis.carparking.model.Employee;
import com.sobis.carparking.service.EmployeeService;

public class ParkingRequestEditor extends PropertyEditorSupport {
	 
    private final EmployeeService employeeService;   
    
    public ParkingRequestEditor(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
 
	public void setAsText(String employeeId) throws IllegalArgumentException {
		System.out.println("in editor converting "+employeeId);
		Employee employee = employeeService.getEmployee(employeeId);
		System.out.println("employee "+employee.getEmail());
		setValue(employee);
	}	
	
	
	
	
}
