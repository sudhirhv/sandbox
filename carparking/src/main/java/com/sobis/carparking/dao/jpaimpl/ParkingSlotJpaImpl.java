package com.sobis.carparking.dao.jpaimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sobis.carparking.dao.ParkingSlotDao;
import com.sobis.carparking.model.ParkingSlot;


@Repository
public class ParkingSlotJpaImpl implements ParkingSlotDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addParkingSlot(ParkingSlot slot) {
		entityManager.persist(slot);
		
	}

	@Override
	public ParkingSlot getParkingSlot(String slotId) {
		return entityManager.find(ParkingSlot.class, slotId);	
	}

	@Override
	public List<ParkingSlot> getAllParkingSlots() {
		TypedQuery<ParkingSlot> query = entityManager.createQuery("select ps from ParkingSlot ps", ParkingSlot.class);		
		return query.getResultList();
	}

}
