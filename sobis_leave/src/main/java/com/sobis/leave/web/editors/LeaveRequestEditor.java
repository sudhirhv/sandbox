package com.sobis.leave.web.editors;

import java.beans.PropertyEditorSupport;

import com.sobis.leave.model.Employee;
import com.sobis.leave.service.EmployeeService;

public class LeaveRequestEditor extends PropertyEditorSupport {
	 
    private final EmployeeService employeeService;
 
    public LeaveRequestEditor(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
 
	public void setAsText(String employeeId) throws IllegalArgumentException {
		System.out.println("in editor converting "+employeeId);
		Employee employee = employeeService.getEmployeeById(employeeId);
		setValue(employee);
	}
}
