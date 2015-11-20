package com.sudhir.hotel;
import java.util.HashSet;
import java.util.Set;

import com.sudhir.corridor.MainCorridor;
import com.sudhir.corridor.SubCorridor;


public class Hotel {

	private Set<Floor> floors = new HashSet<Floor>();		

	public Hotel(Set<Floor> floors) {
		System.out.println("size "+floors.size());
		this.setFloors(floors);
	}

	public Hotel(int noOfMainCorridors, int noOfSubCorridors, int noOfFloors) throws Exception {

		if(noOfFloors < 1) throw new Exception("Floor size should atleast be 1 and above");
		if(noOfMainCorridors < 1) throw new Exception("Floor should have atleast one main corridor");

		for (int i = 0; i < noOfFloors; i++) {
			floors.add(new Floor(noOfMainCorridors, noOfSubCorridors, i+1));
		}
		this.setFloors(floors);
	}

	public Set<Floor> getFloors() {
		return floors;
	}

	public Floor getFloor(int floorNo) {
		Floor floor=null;
		for (Floor fl : getFloors() ) {			
			if(floorNo == fl.getFloorNo()) floor = fl;			
		}		
		return floor;
	}

	public void setFloors(Set<Floor> floors) {
		this.floors = floors;
	}

	//public int getPowerConsumption(Hotel hotel) {
	public int getPowerConsumption() {
		int powerConsumed = 0;
		for (Floor floor : getFloors()) {
			powerConsumed = powerConsumed  + floor.getPowerConsumption();
		}		
		return powerConsumed;
	}

	private void hotel(Set<Floor> floors) {
		this.setFloors(floors);
	}

	/*public void displayHotelStatus(Hotel hotel) {
		Set<Floor> floors = new HashSet<Floor>();
		floors = hotel.getFloors();
		System.out.println("No of floors - " + hotel.getFloors().size());
		for (Floor floor : floors) {
			floor.displayPowerStatus(floor);
		}
	}*/

	public void displayHotelStatus() {
		Set<Floor> floors = new HashSet<Floor>();
		floors = getFloors();
		System.out.println("No of floors - " + getFloors().size());
		for (Floor floor : floors) {
			floor.displayPowerStatus();
		}
	}
	
	public void checkHotelPowerConsumption() {
		floors = getFloors();		
		//TODO
	}

	public void processCommand(Hotel hotel, String command) throws Exception {
		System.out.println("Executing command-->"+ command);

		try {

			String[] splitCommand = command.split("-");
			if(splitCommand.length<3) throw new Exception("Input command pattern not matching, should be floor no-movement(0/1)-corridor type-corridor no");

			String floorNo = splitCommand[0];
			String movement = splitCommand[1];	
			String corridorType = splitCommand[2];	
			String corridorNo = splitCommand[3];

			boolean state = false;		
			Floor floor = getFloor(Integer.parseInt(floorNo));
			if(floor!=null) {
				state = movement.equals("1") ? true : false; 

				if(corridorType.equals("SC")) {			
					SubCorridor corridor = floor.getSubCorridor(Integer.parseInt(corridorNo));
					if(corridor!=null) corridor.toggleAllLights(state);				
				}

				if(corridorType.equals("MC")) {
					MainCorridor corridor = floor.getMainCorridor(Integer.parseInt(corridorNo));
					if(corridor!=null) corridor.toggleAllLights(state);
				}		
				floor.checkAndBalancePowerConsumption(Integer.parseInt(corridorNo));
			} else {
				throw new Exception("Floor does not exist");
			}
			

		} catch (NumberFormatException nEx) {
			System.out.println("Invalid input");		
		} catch (Exception e) {
			e.printStackTrace();
		}


	}


}
