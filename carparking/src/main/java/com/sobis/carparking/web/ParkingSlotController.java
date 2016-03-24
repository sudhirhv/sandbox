package com.sobis.carparking.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sobis.carparking.model.ParkingSlot;
import com.sobis.carparking.service.ParkingSlotService;


@Controller
public class ParkingSlotController {

	static final Logger logger = LogManager.getLogger(ParkingSlotController.class.getName());
	
	@Autowired
	private ParkingSlotService parkingSlotService;
	
	@RequestMapping("/addParkingSlot.do")
	public @ResponseBody Map<String, Object> addParkingSlot(@ModelAttribute ParkingSlot parkingSlot, BindingResult result) {
		logger.debug("Adding parking slot");
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		try {
			jsonResponse.put("success", true);
			if(result.hasErrors()) {
				jsonResponse.put("success", false);
				jsonResponse.put("errors", result.getAllErrors());
			}			
			parkingSlotService.addParkingSlot(parkingSlot);			
		} catch (Exception e) {
			logger.error("Error occured",e);
		}
		return jsonResponse;
	}
	
}
