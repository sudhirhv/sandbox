package com.sudhir.corridor;
import java.util.HashSet;
import java.util.Set;

import com.sudhir.items.AC;
import com.sudhir.items.Light;


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

	public void toggleAllLights(boolean state) {
		Set<Light> allLights = getLights();
		for (Light light : allLights) {
			light.setState(state);
		}
	}
	
	public void toggleAllACs(boolean state) {
		Set<AC> allACs = getAcs();
		for (AC ac : allACs) {
			ac.setState(state);
		}
	}

	@Override
	public int getTotalPowerConsumption() {
		int powerConsumed = 0;
		
		for (AC ac : getAcs()) {
			powerConsumed = powerConsumed + (ac.isState() ? ac.powerConsumedByAc :  0);
		}
		
		for (Light light : getLights()) {
			powerConsumed = powerConsumed + (light.isState() ? light.powerConsumedByLight : + 0);
		}				
		return powerConsumed;
	}


	@Override
	public void displayPowerStatus() {
		System.out.println("Displaying status of "+getClass().getSimpleName() +" "+getCorridorNo());
		for (Light light : getLights()) {
			System.out.println("Light "+ light.getLightNo() + " : "+ (light.isState() ? "ON" : "OFF"));
		}
		for (AC ac : getAcs()) {
			System.out.println("AC "+ ac.getAcNo() + " : "+ (ac.isState() ? "ON" : "OFF"));			
		}
	}
}
