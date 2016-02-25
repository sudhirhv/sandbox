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
import com.sobis.carparking.model.ParkingRequest;
import com.sobis.carparking.model.ParkingSlot;
import com.sobis.carparking.service.EmployeeService;
import com.sobis.carparking.service.ParkingRequestService;
import com.sobis.carparking.service.ParkingSlotService;


@Controller
public class ParkingRequestController {

	@Autowired
	private ParkingRequestService parkingRequestService;
	
	@Autowired 
	private EmployeeService employeeService;
	
	@Autowired
	private ParkingSlotService parkingSlotService;	
	
	
	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Employee.class, "employee", new ParkingRequestEditor(this.employeeService));
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(ParkingSlot.class, "parkingSlot", new ParkingSlotEditor(this.parkingSlotService));		
    }
	
	@RequestMapping("/addParkingRequest.view")
	public @ResponseBody Map<String, Object> addParkingRequest(@ModelAttribute ParkingRequest parkingRequest, BindingResult result) {		
		
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		jsonResponse.put("success", true);
		if(result.hasErrors()) {
			jsonResponse.put("success", false);
			jsonResponse.put("errors", result.getAllErrors());
		}
		System.out.println("date - "+parkingRequest.getParkingDate());
		System.out.println("name - "+parkingRequest.getEmployee().getEmployeeName());
		parkingRequestService.addParkingRequest(parkingRequest);
		System.out.println(jsonResponse.get("success"));
		return jsonResponse;
	}
	
	@RequestMapping(value="/getAllParkingRequests.view")
	public @ResponseBody Map<String, Object> getAllRequests() {		
		Map<String, Object> jsonResponse = new HashMap<String, Object>();		
		jsonResponse.put("success", true);
		jsonResponse.put("rows", parkingRequestService.getAllRequests());
		return jsonResponse;		
	}
	
	
	
}
