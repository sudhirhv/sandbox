package com.sobis.carparking.service;

import java.util.Date;
import java.util.List;

import com.sobis.carparking.model.ParkingSlot;

public interface ParkingSlotService {
	public void addParkingSlot(ParkingSlot slot);
	
	public ParkingSlot getParkingSlot(String slotId);
	
	public List<ParkingSlot> getAllParkingSlots();
	
	public List<Object[]> getAllParkingSlotsWithStatus(Date date);
	
	
}
