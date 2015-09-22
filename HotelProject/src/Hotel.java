import java.util.HashSet;
import java.util.Set;


public class Hotel {
	
	private Set<Floor> floors = new HashSet<Floor>();		
	
	public Hotel(Set<Floor> floors) {
		System.out.println("size "+floors.size());
		this.setFloors(floors);
	}
	
	public Hotel(int noOfMainCorridors, int noOfSubCorridors, int noOfFloors) {
		for (int i = 0; i < noOfFloors; i++) {
			floors.add(new Floor(noOfMainCorridors, noOfSubCorridors, i+1));
		}
		this.setFloors(floors);
	}
	
	public Set<Floor> getFloors() {
		return floors;
	}

	public Floor getFloor(Hotel hotel, int floorNo) {
		Floor floor=null;
		for (Floor fl : hotel.floors ) {			
			if(floorNo == fl.getFloorNo()) floor = fl;			
		}		
		return floor;
	}
	
	public void setFloors(Set<Floor> floors) {
		this.floors = floors;
	}
	
	public int getPowerConsumption(Hotel hotel) {
		int powerConsumed = 0;
		for (Floor floor : hotel.getFloors()) {
			powerConsumed = powerConsumed  + floor.getPowerConsumption(floor);
		}		
		return powerConsumed;
	}
	
	private void hotel(Set<Floor> floors) {
		this.setFloors(floors);
	}
	
	public void displayHotelStatus(Hotel hotel) {
		Set<Floor> floors = new HashSet<Floor>();
		floors = hotel.getFloors();
		System.out.println("No of floors - " + hotel.getFloors().size());
		for (Floor floor : floors) {
			floor.displayPowerStatus(floor);
		}
	}
	
	public void checkHotelPowerConsumption(Hotel hotel) {
		floors = hotel.getFloors();		
		for (Floor floor : floors) {
			//floor.restrictFloorPowerConsumption(floor);
		}
	}
	
	public void processCommand(Hotel hotel, String command) {
		
		String[] splitCommand = command.split("-");	
		String floorNo = splitCommand[0];
		String movement = splitCommand[1];	
		String corridorType = splitCommand[2];	
		String corridorNo = splitCommand[3];
		boolean state = false;
		System.out.println("floor no " +floorNo);
		Floor floor = getFloor(hotel, Integer.parseInt(floorNo));
		state = movement.equals("1") ? true : false; 
		
		
		if(corridorType.equals("SC")) {			
			SubCorridor corridor = floor.getSubCorridor(floor, Integer.parseInt(corridorNo));
			if(corridor!=null) {				
				corridor.toggleAllLights(corridor, state);
			}
		}
		
		if(corridorType.equals("MC")) {
			MainCorridor corridor = floor.getMainCorridor(floor, Integer.parseInt(corridorNo));
			if(corridor!=null) corridor.toggleAllLights(corridor, state);
		}
		//checkHotelPowerConsumption(hotel);
		floor.restrictFloorPowerConsumption(floor, Integer.parseInt(corridorNo));
	}
	

}
