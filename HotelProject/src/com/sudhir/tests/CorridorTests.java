package com.sudhir.tests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.sudhir.corridor.MainCorridor;
import com.sudhir.items.Light;

public class CorridorTests {

	@Test
	public void createCorridor() {
		MainCorridor  mc = new MainCorridor(3, 1);
		assertNotNull(mc);
		assertEquals(mc.getLights().size(), 3);
		
	}
	
	@Test
	public void toggleLights() {
		MainCorridor  mc = new MainCorridor(3, 1);
		assertNotNull(mc);
		mc.toggleAllLights(false);
		
		for (Light light : mc.getLights()) {
			assertFalse(light.isState());
		}
		
	}
	
	@Test
	public void getPowerConsumption() {
		MainCorridor  mc = new MainCorridor(3, 1);
		assertNotNull(mc);
		System.out.println("lights - "+mc.getLights().size());
	
		mc.toggleAllACs(true);
		mc.toggleAllLights(true);
		System.out.println(mc.getTotalPowerConsumption());
		assertEquals(mc.getTotalPowerConsumption(),25);
		
	}

}
