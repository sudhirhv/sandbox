package com.sobis.carparking.service;

import java.util.Date;
import java.util.List;

import com.sobis.carparking.model.Attendance;
import com.sobis.carparking.model.Employee;

public interface AttendanceService {
	
	public void addAttendance(Date startDate, Date toDate, Employee employee);
	
	public List<Attendance> getAttendanceDateWise(Date date);
	
	
}
