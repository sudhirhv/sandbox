import java.util.HashSet;
import java.util.Set;


public class Floor {
	
	private int floorNo;		
	private Set<MainCorridor> mainCorridors = new HashSet<MainCorridor>();
	private Set<SubCorridor> subCorridors = new HashSet<SubCorridor>();
	
	public Floor(Set<MainCorridor> mainCorridors, Set<SubCorridor> subCorridors, int floorNo) {
		this.setMainCorridors(mainCorridors);
		this.setSubCorridors(subCorridors);
		this.floorNo = floorNo;
	}
	
	public Floor(int noOfMainCorridors, int noOfSubCorridors, int floorNo) {
		for (int i = 0; i < noOfMainCorridors; i++) {
			MainCorridor corridor = new MainCorridor(1, 1);
			corridor.setCorridorNo(i+1);
			corridor.toggleAllACs(corridor, true);
			corridor.toggleAllLights(corridor, true);
			mainCorridors.add(corridor);
		}
		for (int j = 0; j < noOfSubCorridors; j++) {
			SubCorridor corridor = new SubCorridor(1, 1);
			corridor.setCorridorNo(j+1);
			corridor.toggleAllACs(corridor, true);
			corridor.toggleAllLights(corridor, false);
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
	
	public MainCorridor getMainCorridor(Floor floor, int corridorNo) {	
		MainCorridor mainCorridor = null;
		for (MainCorridor corridor : floor.getMainCorridors()) {
			if(corridor.getCorridorNo() == corridorNo) {
				mainCorridor = corridor;
			}
		}
		return mainCorridor;
	}
	
	public SubCorridor getSubCorridor(Floor floor, int corridorNo) {	
		SubCorridor subCorridor = null;
		for (SubCorridor corridor : floor.getSubCorridors()) {
			if(corridor.getCorridorNo() == corridorNo) {
				subCorridor = corridor;
			}
		}
		return subCorridor;
	}

	public int getPowerConsumption(Floor floor) {
		int powerConsumed = 0;
		for (Corridor corridor : floor.getMainCorridors()) {
			powerConsumed = powerConsumed  + corridor.getTotalPowerConsumption(corridor);
		}
		for (Corridor corridor : floor.getSubCorridors()) {
			powerConsumed = powerConsumed  + corridor.getTotalPowerConsumption(corridor);
		}
		return powerConsumed;
	}
	
	public void displayPowerStatus(Floor floor) {
		System.out.println("============ Floor "+floor.getFloorNo()+"====================");
		//System.out.println("Displaying status of Main corridors");
		for (MainCorridor corridor : floor.getMainCorridors()) {				
			corridor.displayPowerStatus(corridor);
		}			
		//System.out.println("Displaying status of Sub corridors");
		for (SubCorridor corridor : floor.getSubCorridors()) {			
			corridor.displayPowerStatus(corridor);
		}
	}
	
	public void restrictFloorPowerConsumption(Floor floor, int corridorNo) {
		
		Set<AC> allAcs = new HashSet<AC>();	
		int currentPowerConsumption = getCurrentPowerConsumption(floor);
		
		System.out.println("power cap for floor is - "+getPowerCap(floor));
		System.out.println("currentPowerConsumption "+currentPowerConsumption);
		
		boolean state = currentPowerConsumption > getPowerCap(floor) ? false : true;
		
		for (SubCorridor corridor : floor.getSubCorridors()) {
			if(corridor.getCorridorNo()!=corridorNo) {
				corridor.toggleAllACs(corridor, state);
			}
		}
		
		System.out.println("latest "+getCurrentPowerConsumption(floor));
	}
	
	public int getCurrentPowerConsumption(Floor floor) {
		int currentPowerConsumption = 0;
		for (MainCorridor corridor : floor.getMainCorridors()) {
			//System.out.println("power consumption "+corridor.getTotalPowerConsumption(corridor));
			currentPowerConsumption = currentPowerConsumption + corridor.getTotalPowerConsumption(corridor);
		}		
		for (SubCorridor corridor : floor.getSubCorridors()) {			
			//System.out.println("power consumption "+corridor.getTotalPowerConsumption(corridor));
			currentPowerConsumption = currentPowerConsumption + corridor.getTotalPowerConsumption(corridor);			
		}
		return currentPowerConsumption;
	}
	
	public int getPowerCap(Floor floor) {
		int powerCapAt = 0;
		powerCapAt = floor.getMainCorridors().size() * MainCorridor.powerCapAt + floor.getSubCorridors().size() * SubCorridor.powerCapAt;		
		return powerCapAt;
	}


	
}
