package com.sobis.leave.dao.jpaimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sobis.leave.dao.HolidayDao;
import com.sobis.leave.model.Employee;
import com.sobis.leave.model.Holiday;

@Repository
public class HolidayDaoJpaImpl implements HolidayDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addHoliday(Holiday holiday) {
		entityManager.persist(holiday);
	}

	@Override
	public List<Holiday> getAllHolidays() {
		TypedQuery<Holiday> query = entityManager.createQuery("select h from Holiday h", Holiday.class);		
		return query.getResultList();
	}

}
