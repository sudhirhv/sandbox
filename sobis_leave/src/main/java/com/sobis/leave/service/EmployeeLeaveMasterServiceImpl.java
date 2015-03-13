package com.sobis.leave.service;

import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sobis.leave.dao.EmployeeLeaveMasterDao;
import com.sobis.leave.model.EmployeeLeaveMaster;

@Service
@EnableTransactionManagement 
public class EmployeeLeaveMasterServiceImpl implements EmployeeLeaveMasterService {
	
	@Autowired
	private EmployeeLeaveMasterDao employeeLeaveMasterDao;

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public int getAvailableLeaveBalance(String employeeId, int leaveYear) {
		return employeeLeaveMasterDao.getAvailableLeaveBalance(employeeId, leaveYear);		
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addEmployeeLeaveMasterService(EmployeeLeaveMaster employeeLeaveMaster) {		
		DateTime createdDate = new DateTime();
		employeeLeaveMaster.setCreatedOn(createdDate);
		employeeLeaveMaster.setModifiedOn(createdDate);
		employeeLeaveMasterDao.addEmployeeLeaveMaster(employeeLeaveMaster);	
	}

}
