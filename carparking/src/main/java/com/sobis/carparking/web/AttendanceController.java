package com.sobis.carparking.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
		Employee employee = employeeService.getEmployee(employeeId);
		System.out.println("employee "+employee.getEmployeeName());
		Map<String, Object> jsonResponse = new HashMap<String, Object>();						
		attendanceService.addAttendance(fromDate, toDate, employee);
		jsonResponse.put("success", true);
		return jsonResponse;
	}
	
	@RequestMapping("/getAttendanceDateWise.do")
	public @ResponseBody Map<String, Object> getAttendanceDateWise(long date) {	
		Date date1 = new Date(date);
		System.out.println("date - "+date1);				
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		jsonResponse.put("success", true);		
		jsonResponse.put("rows", attendanceService.getAttendanceDateWise(date1));		
		return jsonResponse;
	}
	
}
