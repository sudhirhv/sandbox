package com.sobis.carparking.web;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import com.sobis.carparking.model.ParkingRequest;
import com.sobis.carparking.model.ParkingSlot;
import com.sobis.carparking.service.EmployeeService;
import com.sobis.carparking.service.ParkingRequestService;
import com.sobis.carparking.service.ParkingSlotService;


@Controller
public class ParkingRequestController {

	static final Logger logger = LogManager.getLogger(ParkingRequestController.class.getName());
	
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
	
	@RequestMapping("/addParkingRequest.do")
	public @ResponseBody Map<String, Object> addParkingRequest(@ModelAttribute ParkingRequest parkingRequest, BindingResult result) {		
		logger.debug("Adding Parking request for "+parkingRequest.getEmployee().getEmployeeName());
		Map<String, Object> jsonResponse = new HashMap<String, Object>();		
		try {			
			jsonResponse.put("success", true);
			if(result.hasErrors()) {
				jsonResponse.put("success", false);
				jsonResponse.put("errors", result.getAllErrors());
			}			
			parkingRequestService.addParkingRequest(parkingRequest);
			System.out.println(jsonResponse.get("success"));
			
		} catch (Exception e) {
			logger.debug("Error occured",e);
		}
		return jsonResponse;		
	}
	
	@RequestMapping(value="/getAllParkingRequests.do")
	public @ResponseBody Map<String, Object> getAllRequests() {	
		logger.debug("Getting all parking requests ");
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		try {
			List<ParkingRequest> parkingRequests = parkingRequestService.getAllRequests();
			jsonResponse.put("success", true);
			jsonResponse.put("rows", parkingRequests);
			jsonResponse.put("totalCount", parkingRequests.size());
		} catch (Exception e) {
			logger.debug("Error occured",e);
		}		
		return jsonResponse;		
	}
	
	@RequestMapping(value="/getAllParkingRequestsPerDate.do")
	public @ResponseBody Map<String, Object> getAllRequestsPerDate(long date) {
		Date date1 = new Date(date);
		logger.debug("Getting all parking requests per date "+date1);
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		
		try {
			List<ParkingRequest> parkingRequests = parkingRequestService.getAllRequestsPerDate(date1);
			jsonResponse.put("success", true);
			jsonResponse.put("rows", parkingRequests);
			jsonResponse.put("totalCount", parkingRequests.size());
		} catch (Exception e) {
			logger.debug("Error occured",e); 
		}
		return jsonResponse;		
	}
	
	@RequestMapping(value="/getAllParkingSlotsWithStatus.do")
	public @ResponseBody Map<String, Object> getAllParkingSlotsWithStatus(long date) {		
		Date date1 = new Date(date);
		logger.debug("Getting all parking requests with status "+date1);
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		try {
			List<Object[]> ps = parkingSlotService.getAllParkingSlotsWithStatus(date1);
			jsonResponse.put("success", true);
			jsonResponse.put("rows", ps);		
			jsonResponse.put("totalCount", ps.size());	
		} catch (Exception e) {
			logger.debug("Error occured",e);
		}		
		return jsonResponse;		
	}
	
	@RequestMapping(value="/deleteParkingRequest.do")
	public @ResponseBody Map<String, Object> deleteParkingRequest(String pr_id) {
		logger.debug("Delete parking request "+pr_id);
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		try {
			parkingRequestService.deleteParkingRequest(pr_id);						
			jsonResponse.put("success", true);		
		} catch (Exception e) {
			logger.debug("Error occured",e);
		}
		return jsonResponse;		
	}
	
	
}
