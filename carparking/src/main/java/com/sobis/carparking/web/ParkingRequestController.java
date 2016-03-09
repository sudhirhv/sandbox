package com.sobis.carparking.web;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	    
	    /*binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
		    public void setAsText(long value) {
		        try {
		        	Date date = new Date(value);
		            setValue(new SimpleDateFormat("dd-M-yyyy hh:mm:ss").parse(value));
		        } catch(ParseException e) {
		            setValue(null);
		        }
		    }
		});*/
	    
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
		List<ParkingRequest> parkingRequests = parkingRequestService.getAllRequests();		
		Map<String, Object> jsonResponse = new HashMap<String, Object>();		
		jsonResponse.put("success", true);
		jsonResponse.put("rows", parkingRequests);
		jsonResponse.put("totalCount", parkingRequests.size());
		return jsonResponse;		
	}
	
	@RequestMapping(value="/getAllParkingRequestsPerDate.view")
	public @ResponseBody Map<String, Object> getAllRequestsPerDate(long date) {
		System.out.println("date "+date);
		/*String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		//String date = simpleDateFormat.format(new Date());		
		
		
		   
		System.out.println("datefmt"+simpleDateFormat.format(date1));*/
		Date date1 = new Date(date);
	    List<ParkingRequest> parkingRequests = parkingRequestService.getAllRequestsPerDate(date1);
		Map<String, Object> jsonResponse = new HashMap<String, Object>();		
		jsonResponse.put("success", true);
		jsonResponse.put("rows", parkingRequests);
		jsonResponse.put("totalCount", parkingRequests.size());
		return jsonResponse;		
	}
	
	@RequestMapping(value="/getAllParkingSlotsWithStatus.view")
	public @ResponseBody Map<String, Object> getAllParkingSlotsWithStatus(long date) {		
		Date date1 = new Date(date);
		List<Object[]> ps = parkingSlotService.getAllParkingSlotsWithStatus(date1);		
		Map<String, Object> jsonResponse = new HashMap<String, Object>();		
		jsonResponse.put("success", true);
		jsonResponse.put("rows", ps);		
		jsonResponse.put("totalCount", ps.size());		
		return jsonResponse;		
	}
	
	@RequestMapping(value="/deleteParkingRequest.view")
	public @ResponseBody Map<String, Object> deleteParkingRequest(String pr_id) {		
		parkingRequestService.deleteParkingRequest(pr_id);		
		Map<String, Object> jsonResponse = new HashMap<String, Object>();		
		jsonResponse.put("success", true);		
		return jsonResponse;		
	}
	
	
}
