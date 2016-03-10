package com.sobis.carparking.web;

import java.util.HashMap;
import java.util.Map;

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

	@Autowired
	private ParkingSlotService parkingSlotService;
	
	@RequestMapping("/addParkingSlot.do")
	public @ResponseBody Map<String, Object> addEmployee(@ModelAttribute ParkingSlot parkingSlot, BindingResult result) {		
		
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		jsonResponse.put("success", true);
		if(result.hasErrors()) {
			jsonResponse.put("success", false);
			jsonResponse.put("errors", result.getAllErrors());
		}
		System.out.println("name - "+parkingSlot.getSlotPosition());
		parkingSlotService.addParkingSlot(parkingSlot);
		System.out.println(jsonResponse.get("success"));
		return jsonResponse;
	}
	
}
