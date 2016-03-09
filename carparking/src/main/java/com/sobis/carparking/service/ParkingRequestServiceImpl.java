package com.sobis.carparking.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sobis.carparking.dao.ParkingRequestDao;
import com.sobis.carparking.model.ParkingRequest;

@Service
@EnableTransactionManagement
public class ParkingRequestServiceImpl implements ParkingRequestService {

	@Autowired
	private ParkingRequestDao parkingRequestDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addParkingRequest(ParkingRequest parkingRequest) {
		Date createdDate = new Date();
		parkingRequest.setCreatedOn(createdDate);
		parkingRequest.setModifiedOn(createdDate);
		parkingRequestDao.addParkingRequest(parkingRequest);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public ParkingRequest getParkingRequest(String requestId) {
		return null;
		
	}

	@Override
	public List<ParkingRequest> getAllRequests() {
		List<ParkingRequest> parkingRequests= parkingRequestDao.getAllRequests();	
		return parkingRequests;		
	}

	@Override
	public List<ParkingRequest> getAllRequestsPerDate(Date date) {		
		return parkingRequestDao.getAllRequestsPerDate(date);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteParkingRequest(String pr_id) {
		parkingRequestDao.deleteParkingRequest(pr_id);		
	}
	
	

}
