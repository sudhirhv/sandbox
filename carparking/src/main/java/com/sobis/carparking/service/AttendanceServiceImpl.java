package com.sobis.carparking.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sobis.carparking.dao.AttendanceDao;
import com.sobis.carparking.dao.jpaimpl.AttendanceDaoJpaImpl;
import com.sobis.carparking.model.Attendance;
import com.sobis.carparking.model.Employee;

@Service
@EnableTransactionManagement // we need to mention this for using @transactions
public class AttendanceServiceImpl implements AttendanceService {

	static final Logger logger = LogManager.getLogger(AttendanceServiceImpl.class);
	
	@Autowired
	private AttendanceDao attendanceDao;
	

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addAttendance(Date startDate, Date endDate, Employee employee) {
		
		Date createdDate = new Date();
		String employeeId = employee.getEmployeeId();
		LocalDate start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate end = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		//for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) { // excluding enddate
		for (LocalDate date = start; !start.isAfter(end) && !date.isAfter(end); date = date.plusDays(1)) { //including endate			
			if(attendanceDao.getAttendanceDateWise(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()), employeeId).size() == 0) {
				System.out.println("creating for "+date);
				Attendance attendance = new Attendance();
				attendance.setDate(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
				attendance.setEmployee(employee);			
				attendance.setCreatedOn(createdDate);
				attendance.setModifiedOn(createdDate);		    
			    attendanceDao.addAttendance(attendance);
			} else {
				logger.debug("Record exists for date"+date);
			}
		}
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<Attendance> getAttendanceDateWise(Date date) {
		return attendanceDao.getAttendanceDateWise(date); 
	}
	
}

