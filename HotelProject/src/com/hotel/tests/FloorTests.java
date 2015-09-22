package com.hotel.tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import com.hotel.src.Floor;

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
	

}
