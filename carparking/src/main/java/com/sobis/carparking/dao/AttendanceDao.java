package com.sobis.carparking.dao;

import java.util.Date;
import java.util.List;

import com.sobis.carparking.model.Attendance;
import com.sobis.carparking.model.Employee;

public interface AttendanceDao {

	public void addAttendance(Attendance attendance);
	
	public List<Attendance> getAttendanceDateWise(Date date);
	
	public List<Attendance> getAttendanceDateWise(Date date, String employeeId);
}
