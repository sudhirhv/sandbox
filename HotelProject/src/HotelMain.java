import java.util.HashSet;
import java.util.Set;

public class HotelMain {

	public static void main(String[] args) {

		int noOffloors = 2;
		int noOfMainCorridors = 1;
		int noOfSubCorridors = 2;

		Set<Floor> floors = new HashSet<Floor>();
		Set<MainCorridor> mainCorridors = new HashSet<MainCorridor>();
		Set<SubCorridor> subCorridors = new HashSet<SubCorridor>();
		
		MainCorridor mainCorridor = null;
		SubCorridor subCorridor = null;
		
		String command = "1-1-SC-2";
		String delimiter = "-";
		String[] splitCommand = command.split(delimiter);
		System.out.println(splitCommand);
		String floorNo = splitCommand[0];
		System.out.println("floorNo "+floorNo);
		String movement = splitCommand[1];
		System.out.println("movement "+movement);
		String corridorType = splitCommand[2];
		System.out.println("corridorType "+corridorType);
		String corridorNo = splitCommand[3];
		System.out.println("corridorNo "+corridorNo);
		boolean state = false;
	
		for (int i = 0; i < noOfMainCorridors; i++) {
			MainCorridor corridor = new MainCorridor(1, 1);
			corridor.setCorridorNo(i+1);
			mainCorridors.add(corridor);
		}
		for (int i = 0; i < noOfSubCorridors; i++) {
			SubCorridor corridor = new SubCorridor(1, 1);
			corridor.setCorridorNo(i+1);
			subCorridors.add(corridor);
		}
		for (int i = 0; i < noOffloors; i++) {
			Floor floor = new Floor(mainCorridors, subCorridors, i+1);
			floors.add(floor);
		}
		
		Hotel hotel = new Hotel(floors);
		
		HotelMain hotelMain = new HotelMain();
		hotelMain.displayStateOfHotel(hotel);
		
		Set<Floor> allFloors = hotel.getFloors();		
		Set<SubCorridor> allSubCorridors = new HashSet<SubCorridor>();
		Set<MainCorridor> allMainCorridors = new HashSet<MainCorridor>();
		Set<Light> allLights = new HashSet<Light>();
		Set<AC> allAcs = new HashSet<AC>();
		
		for (Floor floor : allFloors) {
			if(floor.getFloorNo()==Integer.parseInt(floorNo)) {
				if(movement.equals("1")) {
					System.out.println("matched movement");
					if(corridorType.equals("SC")) {
						System.out.println("mathed SC");
						allSubCorridors = floor.getSubCorridors();
						for (Corridor corridor : allSubCorridors) {
							if(corridor.getCorridorNo()==Integer.parseInt(corridorNo)) {
								System.out.println("matched corridor");
								allLights = corridor.getLights();
								for (Light light : allLights) {
									light.setState(true);
								}
								hotelMain.capTotalConsumption((SubCorridor) corridor);
							}
						}
					} else {
						allMainCorridors = floor.getMainCorridors();	
						for (Corridor corridor : allMainCorridors) {
							if(corridor.getCorridorNo()==Integer.parseInt(corridorNo)) {
								allLights = corridor.getLights();
								for (Light light : allLights) {
									light.setState(true);
								}
								
							}
						}
					}
				} else {
					
				}
			}
		}
		System.out.println(" ------------------ after processing command -----------------------------");
		hotelMain.displayStateOfHotel(hotel);
		
	}
	
	public void displayStateOfHotel(Hotel hotel){
		
		Set<Floor> floors = new HashSet<Floor>();
		Set<MainCorridor> mainCorridors = new HashSet<MainCorridor>();
		Set<SubCorridor> subCorridors = new HashSet<SubCorridor>();
		
		floors = hotel.getFloors();
		System.out.println("No of floors " + hotel.getFloors().size());
		
		for (Floor floor : floors) {
			for (MainCorridor corridor : floor.getMainCorridors()) {
				for (Light light : corridor.getLights()) {
					System.out.println(" floor no - "+ floor.getFloorNo() +" corridor no - "+corridor.getCorridorNo() +" type - "+corridor.type+"  light no - "+ light.getLightNo() + " state --> "+ light.isState());
				}
				for (AC ac : corridor.getAcs()) {
					System.out.println(" floor no - "+ floor.getFloorNo() +" corridor no - "+corridor.getCorridorNo() +" type - "+corridor.type+ "  ac no - "+ ac.getAcNo() + " state --> "+ ac.isState());
				}
			}			
			for (SubCorridor corridor : floor.getSubCorridors()) {	
				
				for (Light light : corridor.getLights()) {
					System.out.println(" floor no - "+ floor.getFloorNo() +" corridor no - "+corridor.getCorridorNo() +" type - "+corridor.type+ "  light no - "+ light.getLightNo() + " state --> "+ light.isState());
				}
				for (AC ac : corridor.getAcs()) {
					System.out.println(" floor no - "+ floor.getFloorNo() +" corridor no - "+corridor.getCorridorNo() +" type - "+corridor.type+ "  ac no - "+ ac.getAcNo() + " state --> "+ ac.isState());
				}
			}
		}
	}
	
	public void capTotalConsumption(SubCorridor corridor) {
		Set<AC> allAcs = new HashSet<AC>();
		System.out.println("power consumption "+corridor.getTotalPowerConsumption(corridor));
		if(corridor.getTotalPowerConsumption(corridor) > 10) {
			allAcs = corridor.getAcs();
			for (AC ac : allAcs) {
				ac.setState(false);
			}
		}
		System.out.println("power consumption "+corridor.getTotalPowerConsumption(corridor));
	}
}


