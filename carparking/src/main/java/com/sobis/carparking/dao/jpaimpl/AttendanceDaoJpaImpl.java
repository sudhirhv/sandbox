package com.sobis.carparking.dao.jpaimpl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sobis.carparking.dao.AttendanceDao;
import com.sobis.carparking.model.Attendance;
import com.sobis.carparking.model.Employee;
import com.sobis.carparking.web.AttendanceController;

@Repository
public class AttendanceDaoJpaImpl implements AttendanceDao {

	static final Logger logger = LogManager.getLogger(AttendanceDaoJpaImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
		
	/*public void addAttendance(Date fromDate, Date toDate, Employee employee) {
		LocalDate start = fromDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate end = toDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
		    // Do your job here with `date`.
		    System.out.println(date);
		    entityManager.persist(arg0);
		}
		
	}*/

	@Override
	public List<Attendance> getAttendanceDateWise(Date date) {
		String jql = "select a from Attendance a where a.date between :start and :end";
		Query query = entityManager.createQuery(jql);
		
		Date todayMorning = DateUtils.truncate(date, Calendar.DATE);
		Date todayEvening = DateUtils.addSeconds(DateUtils.addMinutes(DateUtils.addHours(todayMorning, 23), 59), 59);
		
		System.out.println("today morning"+todayMorning.getDate());
		System.out.println("today todayEvening"+todayEvening.getDate());
		
		query.setParameter("start",todayMorning);
		query.setParameter("end",todayEvening);	
		return query.getResultList();
	}

	@Override
	public void addAttendance(Attendance attendance) {
		entityManager.persist(attendance);
		
	}

	@Override
	public List<Attendance> getAttendanceDateWise(Date date, String employeeId) {
		logger.debug("Checking if employee has attendance record for " +date);
		String jql = "select a from Attendance a where a.date between :start and :end and a.employee.employeeId=:employeeId";
		Query query = entityManager.createQuery(jql);
		
		Date todayMorning = DateUtils.truncate(date, Calendar.DATE);
		Date todayEvening = DateUtils.addSeconds(DateUtils.addMinutes(DateUtils.addHours(todayMorning, 23), 59), 59);
		
		query.setParameter("employeeId", employeeId);
		query.setParameter("start",todayMorning);
		query.setParameter("end",todayEvening);	
		return query.getResultList();		
	}

}
