package com.sobis.carparking.dao.jpaimpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.time.DateUtils;
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
	public ParkingRequest getParkingRequest(String requestId) {
		return entityManager.find(ParkingRequest.class, requestId);	
	}

	@Override
	public List<ParkingRequest> getAllRequests() {
		TypedQuery<ParkingRequest> query = entityManager.createQuery("select pr from ParkingRequest pr", ParkingRequest.class);		
		return query.getResultList();
	}
	

	@Override
	public List<ParkingRequest> getAllRequestsPerDate(Date date) {
		//TypedQuery<ParkingRequest> query = entityManager.createQuery("select pr from ParkingRequest pr where pr.parkingDate=:dateSelected", ParkingRequest.class);
		//String jql = "select pr from ParkingRequest pr where pr.parkingDate=:parkingDate";
		String jql = "select pr from ParkingRequest pr where pr.parkingDate between :start and :end";
		Query query = entityManager.createQuery(jql);
		
		Date todayMorning = DateUtils.truncate(date, Calendar.DATE);
		Date todayEvening = DateUtils.addSeconds(DateUtils.addMinutes(DateUtils.addHours(todayMorning, 23), 59), 59);
		
		System.out.println("today morning"+todayMorning.getDate());
		System.out.println("today todayEvening"+todayEvening.getDate());
		
		query.setParameter("start",todayMorning);
		query.setParameter("end",todayEvening);	
		
		
		return query.getResultList();
	}

}
