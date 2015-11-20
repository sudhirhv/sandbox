package com.sudhir.hotel;

public class HotelMain {

	public static void main(String[] args) throws Exception {

		int noOffloors = 2; // no of floors the hotel must have
		int noOfMainCorridors = 1; // no of main corridors the hotel must have
		int noOfSubCorridors = 2; // no of sub corridors the hotel must have
		
		String listOfCommands[] = new String[2];
		
		// Adjust the length of the array and add more commands,  
		//the list of inputs from the sensor to the array, the pattern is as follows - "floorno - movement(0/1) - SC/MC / corridor no"
		
		listOfCommands[0] = "1-1-SC-2"; //"floorno - movement(0/1) - SC/MC / corridor no"
		listOfCommands[1] = "1-0-SC-2";
		
		/*listOfCommands[0] = "2-0-MC-1";
		listOfCommands[1] = "2-1-SC-2";
		listOfCommands[2] = "2-1-MC-1";*/
		
		Hotel hotel = new Hotel(noOfMainCorridors, noOfSubCorridors, noOffloors);
		System.out.println(" ------------------ Hotel Setup and default status -----------------------------");
		hotel.displayHotelStatus();
		System.out.println(" ------------------ Start Executing commands -----------------------------");
		for (int i = 0; i < listOfCommands.length; i++) {
			System.out.println(" ------------------ Start Command " +i+1+"-----------------------------");
			String command = listOfCommands[i];
			String delimiter = "-";
			String[] splitCommand = command.split(delimiter);
			hotel.processCommand(hotel, command);					
			hotel.displayHotelStatus();
			System.out.println(" ------------------ End Command "+i+1+"-----------------------------");
		}
		System.out.println(" ------------------ End Executing commands -----------------------------");
		
	}
	
}


