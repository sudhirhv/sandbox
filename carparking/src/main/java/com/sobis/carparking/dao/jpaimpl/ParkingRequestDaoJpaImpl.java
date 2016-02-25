package com.sobis.carparking.dao.jpaimpl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sobis.carparking.dao.ParkingRequestDao;
import com.sobis.carparking.model.ParkingRequest;

@Repository
public class ParkingRequestDaoJpaImpl implements ParkingRequestDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addParkingRequest(ParkingRequest parkingRequest) {
		entityManager.persist(parkingRequest);
	}

	@Override
	public ParkingRequestDao getParkingRequest(String requestId) {
		return entityManager.find(ParkingRequestDao.class, requestId);	
	}

	@Override
	public List<ParkingRequest> getAllRequests() {
		TypedQuery<ParkingRequest> query = entityManager.createQuery("select pr from ParkingRequest pr", ParkingRequest.class);		
		return query.getResultList();
	}
	
	

	@Override
	public List<ParkingRequest> getAllRequestsPerDate(Date date) {
		TypedQuery<ParkingRequest> query = entityManager.createQuery("select pr from ParkingRequest pr where parkingDate=", ParkingRequest.class);		
		return query.getResultList();
	}

}
