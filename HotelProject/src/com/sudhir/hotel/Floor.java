package com.sudhir.hotel;
import java.util.HashSet;
import java.util.Set;

import com.sudhir.corridor.Corridor;
import com.sudhir.corridor.MainCorridor;
import com.sudhir.corridor.SubCorridor;
import com.sudhir.items.AC;


public class Floor {
	
	private int floorNo;		
	private Set<MainCorridor> mainCorridors = new HashSet<MainCorridor>();
	private Set<SubCorridor> subCorridors = new HashSet<SubCorridor>();
	
	public Floor(Set<MainCorridor> mainCorridors, Set<SubCorridor> subCorridors, int floorNo) {
		this.setMainCorridors(mainCorridors);
		this.setSubCorridors(subCorridors);
		this.floorNo = floorNo;
	}
	
	public Floor(int noOfMainCorridors, int noOfSubCorridors, int floorNo) throws Exception {
		
		if(noOfMainCorridors < 1) throw new Exception("A floor must have atleast one main corridor");		
		
		for (int i = 0; i < noOfMainCorridors; i++) {
			MainCorridor corridor = new MainCorridor(1, 1);
			corridor.setCorridorNo(i+1);
			corridor.toggleAllACs(true);
			corridor.toggleAllLights(true);
			mainCorridors.add(corridor);
		}
		for (int j = 0; j < noOfSubCorridors; j++) {
			SubCorridor corridor = new SubCorridor(1, 1);
			corridor.setCorridorNo(j+1);
			corridor.toggleAllACs(true);
			corridor.toggleAllLights(false);
			subCorridors.add(corridor);
		}
		this.setMainCorridors(mainCorridors);
		this.setSubCorridors(subCorridors);
		this.floorNo = floorNo;
	}
	
	
	public Set<MainCorridor> getMainCorridors() {
		return mainCorridors;
	}

	public void setMainCorridors(Set<MainCorridor> mainCorridors) {
		this.mainCorridors = mainCorridors;
	}

	public Set<SubCorridor> getSubCorridors() {
		return subCorridors;
	}

	public void setSubCorridors(Set<SubCorridor> subCorridors) {
		this.subCorridors = subCorridors;
	}

	public int getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}
	
	public MainCorridor getMainCorridor(int corridorNo) throws Exception {	
		MainCorridor mainCorridor = null;
		for (MainCorridor corridor : getMainCorridors()) {
			if(corridor.getCorridorNo() == corridorNo) {
				mainCorridor = corridor;
			}
		}
		if(mainCorridor==null) throw new Exception("Main Corridor does not exist");
		return mainCorridor;
	}
	
	public SubCorridor getSubCorridor(int corridorNo) throws Exception {	
		SubCorridor subCorridor = null;
		for (SubCorridor corridor : getSubCorridors()) {
			if(corridor.getCorridorNo() == corridorNo) {
				subCorridor = corridor;
			}
		}		
		if(subCorridor==null) throw new Exception("Sub Corridor does not exist");
		return subCorridor;
	}

	//public int getPowerConsumption(Floor floor) {
	public int getPowerConsumption() {
		int powerConsumed = 0;
		for (Corridor corridor : getMainCorridors()) {
			powerConsumed = powerConsumed  + corridor.getTotalPowerConsumption();
		}
		for (Corridor corridor : getSubCorridors()) {
			powerConsumed = powerConsumed  + corridor.getTotalPowerConsumption();
		}
		return powerConsumed;
	}
	
	public void displayPowerStatus() {
		System.out.println("============ Floor "+getFloorNo()+"====================");
		//System.out.println("Displaying status of Main corridors");
		for (MainCorridor corridor : getMainCorridors()) {				
			corridor.displayPowerStatus();
		}			
		//System.out.println("Displaying status of Sub corridors");
		for (SubCorridor corridor : getSubCorridors()) {			
			corridor.displayPowerStatus();
		}
	}
	
	public void checkAndBalancePowerConsumption(int corridorForWhichInputWasProvidedFor) {
		
		Set<AC> allAcs = new HashSet<AC>();	
		int currentPowerConsumption = getCurrentPowerConsumption();
		
		System.out.println("power cap for floor is - "+getPowerCap());
		System.out.println("currentPowerConsumption "+currentPowerConsumption);
		
		boolean state = currentPowerConsumption > getPowerCap() ? false : true;		
		for (SubCorridor corridor : getSubCorridors()) {
			if(corridor.getCorridorNo()!=corridorForWhichInputWasProvidedFor) {				
				corridor.toggleAllACs(state);
			}
		}
		
		System.out.println("adjusted power consumption "+getCurrentPowerConsumption());
	}
	
	public int getCurrentPowerConsumption() {
		int currentPowerConsumption = 0;
		for (MainCorridor corridor : getMainCorridors()) {
			//System.out.println("power consumption "+corridor.getTotalPowerConsumption(corridor));
			currentPowerConsumption = currentPowerConsumption + corridor.getTotalPowerConsumption();
		}		
		for (SubCorridor corridor : getSubCorridors()) {			
			//System.out.println("power consumption "+corridor.getTotalPowerConsumption(corridor));
			currentPowerConsumption = currentPowerConsumption + corridor.getTotalPowerConsumption();			
		}
		return currentPowerConsumption;
	}
	
	public int getPowerCap() {
		int powerCapAt = 0;
		powerCapAt = getMainCorridors().size() * MainCorridor.powerCapAt + getSubCorridors().size() * SubCorridor.powerCapAt;		
		return powerCapAt;
	}


	
}
