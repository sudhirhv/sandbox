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
	
		for (int i = 0; i < noOfMainCorridors; i++) {
			MainCorridor corridor = new MainCorridor(1, 1);
			corridor.setCorridorNo(i);
			mainCorridors.add(corridor);
		}
		for (int i = 0; i < noOfSubCorridors; i++) {
			SubCorridor corridor = new SubCorridor(1, 1);
			corridor.setCorridorNo(i);
			subCorridors.add(corridor);
		}
		for (int i = 0; i < noOffloors; i++) {
			Floor floor = new Floor(mainCorridors, subCorridors, i);
			floors.add(floor);
		}
		
		Hotel hotel = new Hotel(floors);
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

}
