package com.sobis.carparking.service;

import java.util.Date;
import java.util.List;

import com.sobis.carparking.dao.ParkingRequestDao;
import com.sobis.carparking.model.ParkingRequest;

public interface ParkingRequestService {
	
	public void addParkingRequest(ParkingRequest parkingRequest);
	
	public ParkingRequestDao getParkingRequest(String requestId);
	
	public List<ParkingRequest> getAllRequests();
	
	public List<ParkingRequest> getAllRequestsPerDate(Date date);
		
}
