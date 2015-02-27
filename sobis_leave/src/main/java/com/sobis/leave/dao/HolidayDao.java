package com.sobis.leave.dao;

import java.util.List;

import com.sobis.leave.model.Holiday;

public interface HolidayDao {
	
	public void addHoliday(Holiday holiday);
	
	public List<Holiday> getAllHolidays();
}
