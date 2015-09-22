package com.sudhir.tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import com.sudhir.hotel.Floor;
import com.sudhir.hotel.Hotel;

public class FloorTests {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void createFloor() throws Exception {
		Floor floor = new Floor(1, 1, 1);
		
		assertNotNull(floor);
		System.out.println("created floor with Main corridor - "+floor.getMainCorridors().size());
		assertEquals(floor.getMainCorridors().size(), 1);
		
	}
	
	@Test
	public void getMainCorridor() throws Exception {
		Floor floor = new Floor(1, 1, 1);
		assertNotNull(floor);
		System.out.println("created floor with Main corridor - "+floor.getMainCorridors().size());
		
		assertNull(floor.getMainCorridor(floor, 2));
		assertNotNull(floor.getMainCorridor(floor, 1));
	}
	
	@Test
	public void checkPowerConsumption() throws Exception {
		Floor floor = new Floor(1, 1, 1);
		assertNotNull(floor);
		System.out.println("created floor with Main corridor - "+floor.getMainCorridors().size());
		assertEquals(floor.getPowerConsumption(floor), 25);
	}
	
	@Test
	public void balancePowerConsumption() throws Exception {
		Hotel hotel = new Hotel(2, 1, 1);
		assertNotNull(hotel);
		Floor floor = hotel.getFloor(hotel, 1);		
		System.out.println("created floor with Main corridor - "+floor.getMainCorridors().size());
		assertNotNull(floor);
		floor.checkAndBalancePowerConsumption(floor, 0);
		hotel.displayHotelStatus(hotel);
	}
	
	@Test
	public void getCorridor() throws Exception {
		Floor floor = new Floor(1, 1, 1);
		assertNotNull(floor);
		System.out.println("created floor with Main corridor - "+floor.getMainCorridors().size());
		assertNotNull(floor.getMainCorridor(floor, 1));
		assertNotNull(floor.getSubCorridor(floor, 1));
	}
	

}
