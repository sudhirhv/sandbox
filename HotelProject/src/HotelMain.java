import java.util.HashSet;
import java.util.Set;

public class HotelMain {

	public static void main(String[] args) {

		int noOffloors = 2;
		int noOfMainCorridors = 1;
		int noOfSubCorridors = 2;
		//pattern - floorno - movement(0/1) - SC/MC / corridor no
		String command = "1-1-SC-2";
		String delimiter = "-";
		String[] splitCommand = command.split(delimiter);	
		String floorNo = splitCommand[0];	
		String movement = splitCommand[1];	
		String corridorType = splitCommand[2];	
		String corridorNo = splitCommand[3];
	
		boolean state = false;
		
		Hotel hotel = new Hotel(noOfMainCorridors, noOfSubCorridors, noOffloors);
		System.out.println(" ------------------ Hotel Setup and default status -----------------------------");
		hotel.displayHotelStatus(hotel);
		hotel.processCommand(hotel, command);					
		System.out.println(" ------------------ after processing command -----------------------------");
		hotel.displayHotelStatus(hotel);
	}
	
	
	
}


