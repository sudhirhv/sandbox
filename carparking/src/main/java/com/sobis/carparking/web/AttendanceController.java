package com.sobis.carparking.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sobis.carparking.model.Employee;
import com.sobis.carparking.service.AttendanceService;
import com.sobis.carparking.service.EmployeeService;

@Controller
public class AttendanceController {

	static final Logger logger = LogManager.getLogger(AttendanceController.class.getName());
	
	@Autowired
	private AttendanceService attendanceService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Employee.class, "employee", new ParkingRequestEditor(this.employeeService));
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	@RequestMapping("/addAttendance.do")
	public @ResponseBody Map<String, Object> addAttendance(Date fromDate, Date toDate, String employeeId) {
		logger.debug("Adding attendance");
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		try {
			Employee employee = employeeService.getEmployee(employeeId);
			logger.debug("Adding attendance for employee "+employee);									
			attendanceService.addAttendance(fromDate, toDate, employee);
			jsonResponse.put("success", true);
		} catch (Exception e) {
			logger.error("Error occured",e);
		}
		return jsonResponse;
	}
	
	@RequestMapping("/getAttendanceDateWise.do")
	public @ResponseBody Map<String, Object> getAttendanceDateWise(long date) {
		Date date1 = new Date(date);
		logger.debug("Getting attendance for date "+date1);		
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		try {
			jsonResponse.put("success", true);		
			jsonResponse.put("rows", attendanceService.getAttendanceDateWise(date1));	
		} catch (Exception e) {
			logger.error("Error occured",e);
		}		
		return jsonResponse;
	}
	
}
