package com.sobis.carparking.web;

import java.beans.PropertyEditorSupport;

import com.sobis.carparking.model.ParkingSlot;
import com.sobis.carparking.service.ParkingSlotService;

public class ParkingSlotEditor extends PropertyEditorSupport {
	
	  private final ParkingSlotService parkingSlotService;   
	    
	    public ParkingSlotEditor(ParkingSlotService parkingSlotService) {
	        this.parkingSlotService = parkingSlotService;
	    }
	 
		public void setAsText(String slotId) throws IllegalArgumentException {
			System.out.println("in editor converting "+slotId);
			ParkingSlot slot = parkingSlotService.getParkingSlot(slotId);
			System.out.println("slot "+slot.getSlotType());
			setValue(slot);
		}	
}
