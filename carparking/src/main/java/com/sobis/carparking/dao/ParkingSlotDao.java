package com.sobis.carparking.dao;

import java.util.Date;
import java.util.List;

import com.sobis.carparking.model.ParkingSlot;

public interface ParkingSlotDao {

	public void addParkingSlot(ParkingSlot slot);
	
	public ParkingSlot getParkingSlot(String slotId);
	
	public List<ParkingSlot> getAllParkingSlots();
	
	public List<Object[]> getAllParkingSlotsWithStatus(Date date);
}
