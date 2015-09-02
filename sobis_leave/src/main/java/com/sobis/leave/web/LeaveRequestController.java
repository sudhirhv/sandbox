package com.sobis.leave.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sobis.leave.model.Employee;
import com.sobis.leave.model.LeaveRequest;
import com.sobis.leave.service.EmployeeLeaveMasterService;
import com.sobis.leave.service.EmployeeService;
import com.sobis.leave.service.LeaveRequestService;
import com.sobis.leave.web.editors.LeaveRequestEditor;
import com.sobis.leave.web.editors.StringToJodaDateTimeConverter;



@Controller
public class LeaveRequestController {

	@Autowired
	private LeaveRequestService leaveRequestService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeLeaveMasterService employeeLeaveMasterService;
	
	
	/*@ModelAttribute("employees")
	public List<Employee> getEmployees() {
		//return leaveRequestService.getAllEmployees();
		return null;
	}*/
	
/*	@ModelAttribute("availableLeaveBalance")
	public int getAvailableLeaveBalance(String employeeId, int leaveYear) {		
		return employeeLeaveMasterService.getAvailableLeaveBalance(employeeId, leaveYear);
	}
	
	@ModelAttribute("approver")
	public Employee getApprover(String employeeId) {		
		return employeeService.getApprover(employeeId);
	}*/
	
	/*@RequestMapping(value="/employees.view")
	public @ResponseBody Map<String, Object> getEmployees() {
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		jsonResponse.put("success", true);
		jsonResponse.put("rows", employeeService.getAllEmployees());
		return jsonResponse;
	}*/
	
	/*@ModelAttribute("leaveRequest")	
	public LeaveRequest prepareLeaveRequest(HttpServletRequest request) {
		String reqName = request.getParameter("requestorName");
		System.out.println("reqName xxx "+reqName);
		System.out.println(employeeService.getEmployeeById(reqName).getEmployeeName());
		
		//System.out.println(employeeService.getEmployeeById(request.getParameter("requestorName")).getEmployeeName());
		LeaveRequest leaveRequest = new LeaveRequest();
		leaveRequest.setRequestorName(employeeService.getEmployeeById(reqName));
		System.out.println("set model");		
		return leaveRequest;
		
	}*/
	
	/*@InitBinder
	protected void initBinder(final HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
	    binder.registerCustomEditor(Employee.class, "requestorName", new PropertyEditorSupport() {	        
	        public void setAsText(String text) {
	        	System.out.println("text "+text);
	            Employee e = employeeService.getEmployeeById(text);
	            setValue(e);
	        }
	    });
	}*/
	
	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Employee.class, "requestorName", new LeaveRequestEditor(this.employeeService));
		binder.registerCustomEditor(Employee.class, "approverName", new LeaveRequestEditor(this.employeeService));
		binder.registerCustomEditor(DateTime.class, new StringToJodaDateTimeConverter());
		
    }

	@RequestMapping(value="/newLeaveRequest.view")
	public @ResponseBody Map<String, Object> newLeaveRequest(@ModelAttribute LeaveRequest leaveRequest, BindingResult result) {
		
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		jsonResponse.put("success", true);
		//jsonResponse.put("rows", employeeService.getAllEmployees());
		
		if(result.hasErrors()) {
			jsonResponse.put("success", false);
			jsonResponse.put("errors", result.getAllErrors());
		}
		
		System.out.println(leaveRequest.getTypeOfLeave());
		System.out.println(leaveRequest.getRequestorName().getEmployeeName());		
		System.out.println(leaveRequest.getApproverName().getEmployeeName());
		System.out.println(leaveRequest.getLeaveStartDate());
		System.out.println(leaveRequest.getLeaveEndDate());
		leaveRequestService.createLeaveRequest(leaveRequest);
		
		return jsonResponse;
	}
	
	@RequestMapping(value="/getAllLeaveRequests.view")
	public @ResponseBody Map<String, Object> getAllRequests() {
		
		Map<String, Object> jsonResponse = new HashMap<String, Object>();		
		jsonResponse.put("success", true);
		jsonResponse.put("rows", leaveRequestService.getAllLeaveRequests());
		return jsonResponse;		
	}
	
	@RequestMapping(value="/calculateLeaveDuration.view")	
	public @ResponseBody Map<String, Object> getEmployeeLeaveDetails(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		DateTime leaveStartDate = new DateTime(Long.parseLong(startDate));
		DateTime leaveEndDate = new DateTime(Long.parseLong(endDate));
		int duration = leaveRequestService.calculateLeaveDuration(leaveStartDate, leaveEndDate);
		jsonResponse.put("success", true);
		jsonResponse.put("duration", duration);
		return jsonResponse;
	}
	
}
