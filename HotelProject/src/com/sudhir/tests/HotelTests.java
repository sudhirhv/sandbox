package com.sudhir.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sudhir.hotel.Hotel;


public class HotelTests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createHotel() throws Exception {
		System.out.println("Creating hotel");
		Hotel hotel = new Hotel(1, 1, 1);
		assertEquals(hotel.getFloors().size(),1);
		assertNotNull(hotel);
		System.out.println("Hotel created and floors are "+hotel.getFloors().size());
	}
	
	@Test
	public void exceuteCommand() throws Exception {
		System.out.println("creating hotel");
		Hotel hotel = new Hotel(1, 1, 1);
		assertNotNull(hotel);
		hotel.processCommand(hotel, "1-0-SC-1");	
		hotel.displayHotelStatus(hotel);
		System.out.println("Command processed");
	}
	
	@Test
	public void getConsumption() throws Exception {
		System.out.println("creating hotel");
		Hotel hotel = new Hotel(1, 1, 1);
		assertNotNull(hotel);
		System.out.println("power consumed - "+hotel.getPowerConsumption(hotel));
	}
  
}
