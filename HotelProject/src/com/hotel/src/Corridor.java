package com.hotel.src;
import java.util.HashSet;
import java.util.Set;


public class Corridor implements CorridorInterface {
	
	private Set<Light> lights = new HashSet<Light>();
	private Set<AC> acs = new HashSet<AC>();
	private int corridorNo;
	
		
	public Corridor(int noOfLights, int noOfAcs) {
		
		for (int i = 0; i < noOfLights; i++) {
			Light light = new Light();
			light.setLightNo(i);			
			getLights().add(light);
		}
		for (int j = 0; j < noOfAcs; j++) {
			AC ac = new AC();
			ac.setAcNo(j);			
			getAcs().add(ac);			
		}
	}
	
	public Set<Light> getLights() {
		return lights;
	}

	public void setLights(Set<Light> lights) {
		this.lights = lights;
	}

	public Set<AC> getAcs() {
		return acs;
	}

	public void setAcs(Set<AC> acs) {
		this.acs = acs;
	}

	public int getCorridorNo() {
		return corridorNo;
	}

	public void setCorridorNo(int corridorNo) {
		this.corridorNo = corridorNo;
	}

	public void toggleAllLights(Corridor corridor, boolean state) {
		Set<Light> allLights = corridor.getLights();
		for (Light light : allLights) {
			light.setState(state);
		}
	}
	
	public void toggleAllACs(Corridor corridor, boolean state) {
		Set<AC> allACs = corridor.getAcs();
		for (AC ac : allACs) {
			ac.setState(state);
		}
	}

	@Override
	public int getTotalPowerConsumption(Corridor corridor) {
		int powerConsumed = 0;
		
		for (AC ac : corridor.getAcs()) {
			powerConsumed = powerConsumed + (ac.isState() ? ac.powerConsumedByAc :  0);
		}
		
		for (Light light : corridor.getLights()) {
			powerConsumed = powerConsumed + (light.isState() ? light.powerConsumedByLight : + 0);
		}				
		return powerConsumed;
	}


	@Override
	public void displayPowerStatus(Corridor corridor) {
		System.out.println("Displaying status of "+corridor.getClass().getSimpleName() +" "+corridor.getCorridorNo());
		for (Light light : corridor.getLights()) {
			System.out.println("Light "+ light.getLightNo() + " : "+ (light.isState() ? "ON" : "OFF"));
		}
		for (AC ac : corridor.getAcs()) {
			System.out.println("AC "+ ac.getAcNo() + " : "+ (ac.isState() ? "ON" : "OFF"));			
		}
	}
}
