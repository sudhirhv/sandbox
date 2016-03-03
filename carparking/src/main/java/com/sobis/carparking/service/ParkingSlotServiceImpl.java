package com.sobis.carparking.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sobis.carparking.dao.ParkingSlotDao;
import com.sobis.carparking.model.ParkingSlot;

@Service
@EnableTransactionManagement
public class ParkingSlotServiceImpl implements ParkingSlotService {

	@Autowired
	private ParkingSlotDao parkingSlotDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addParkingSlot(ParkingSlot slot) {
		Date createdDate = new Date();
		slot.setCreatedOn(createdDate);
		slot.setModifiedOn(createdDate);
		parkingSlotDao.addParkingSlot(slot);	
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public ParkingSlot getParkingSlot(String slotId) {
		return parkingSlotDao.getParkingSlot(slotId);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<ParkingSlot> getAllParkingSlots() {
		return parkingSlotDao.getAllParkingSlots();
	}

	@Override
	public List<Object[]> getAllParkingSlotsWithStatus(Date date) {
		return parkingSlotDao.getAllParkingSlotsWithStatus(date);
	}

}
