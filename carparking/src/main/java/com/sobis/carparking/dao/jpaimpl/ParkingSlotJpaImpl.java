package com.sobis.carparking.dao.jpaimpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.time.DateUtils;
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

	@Override
	public List<Object[]> getAllParkingSlotsWithStatus(Date date) {
		//TypedQuery<ParkingSlot> query = entityManager.createQuery("from ParkingSlot as ps left join pr.id as ParkingRequest", ParkingSlot.class);	
		/*String hql = "select pr.employee.employeeName, ps.slotType from ParkingRequest as pr"
				+ " left join pr.parkingSlot as ps"
				+ " where pr.parkingSlot=ps.id"
				+ " and pr.parkingDate between :start and :end";	*/
		
		String hql = "select pr.employee.employeeName, pr.parkingSlot"
				+ " from ParkingSlot as ps"
				+ " right outer join pr.parkingSlot as pr"
				+ " where pr.parkingDate between :start and :end";
		
		String hql1 = "SELECT t1.id as ps_id, t2.fk_employee as employeeId, t2.parkingDate as parkingDate,"
				+ " (select employeeName from employee e where id=t2.fk_employee) employeeName "
				+ " FROM parkingslot as t1"
				+ " LEFT JOIN parkingrequests as t2"
				+ " ON t1.id = t2.fk_parkingslot"
				+ " and t2.fk_parkingslot in "
				+ " (select fk_parkingslot from parkingrequests "
				+ "		where parkingDate between :start and :end) and parkingDate between :start1 and :end1";
			
		/*SELECT * FROM parkingslot as t1
		LEFT JOIN parkingrequests as t2 ON t1.id = t2.fk_parkingslot and t2.fk_parkingslot in 
		(select fk_parkingslot from parkingrequests where parkingDate='2016-02-26' ) and parkingDate='2016-02-26'*/
		
		Date todayMorning = DateUtils.truncate(date, Calendar.DATE);
		Date todayEvening = DateUtils.addSeconds(DateUtils.addMinutes(DateUtils.addHours(todayMorning, 23), 59), 59);
		//Query query = entityManager.createQuery(hql);
		Query query = entityManager.createNativeQuery(hql1, "ParkingSlotMapping");
		query.setParameter("start",todayMorning);
		query.setParameter("end",todayEvening);	
		query.setParameter("start1",todayMorning);
		query.setParameter("end1",todayEvening);	
		
		return query.getResultList();	
	}

}
