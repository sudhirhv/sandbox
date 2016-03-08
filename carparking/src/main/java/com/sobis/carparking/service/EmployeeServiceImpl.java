package com.sobis.carparking.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sobis.carparking.dao.EmployeeDao;
import com.sobis.carparking.dao.FileDao;
import com.sobis.carparking.model.Employee;
import com.sobis.carparking.model.File;

@Service
@EnableTransactionManagement // we need to mention this for using @transactions
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private FileDao fileDao;
		
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addEmployee(Employee employee) {
		Date createdDate = new Date();
		employee.setCreatedOn(createdDate);
		employee.setModifiedOn(createdDate);
		employeeDao.addEmployee(employee);	
	}

	@Override
	public Employee getEmployee(String employeeId) {
		return employeeDao.getEmployee(employeeId);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();		
	}

	@Override
	public File getImage(String employeeId) {
		return employeeDao.getEmployee(employeeId).getImage();
	}

	@Override
	public Employee getEmployeeByUserName(String userName) {
		return employeeDao.getEmployeeByUserName(userName);
	}

}
