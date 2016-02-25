package com.sobis.carparking.dao;

import java.util.Date;
import java.util.List;

import com.sobis.carparking.model.ParkingRequest;

public interface ParkingRequestDao {

	public void addParkingRequest(ParkingRequest parkingRequest);
	
	public ParkingRequestDao getParkingRequest(String requestId);
	
	public List<ParkingRequest> getAllRequests();
	
	public List<ParkingRequest> getAllRequestsPerDate(Date date);
	
}
