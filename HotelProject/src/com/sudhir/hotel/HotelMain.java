package com.sudhir.hotel;

public class HotelMain {

	public static void main(String[] args) throws Exception {

		int noOffloors = 2;
		int noOfMainCorridors = 1;
		int noOfSubCorridors = 2;
		
		String listOfCommands[] = new String[2];
		//pattern - floorno - movement(0/1) - SC/MC / corridor no
		listOfCommands[0] = "1-1-SC-2";
		listOfCommands[1] = "1-0-SC-2";
		
		Hotel hotel = new Hotel(noOfMainCorridors, noOfSubCorridors, noOffloors);
		System.out.println(" ------------------ Hotel Setup and default status -----------------------------");
		hotel.displayHotelStatus(hotel);
		System.out.println(" ------------------ Start Executing commands -----------------------------");
		for (int i = 0; i < listOfCommands.length; i++) {
			System.out.println(" ------------------ Start Command " +i+1+"-----------------------------");
			String command = listOfCommands[i];
			String delimiter = "-";
			String[] splitCommand = command.split(delimiter);
			hotel.processCommand(hotel, command);					
			hotel.displayHotelStatus(hotel);
			System.out.println(" ------------------ End Command "+i+1+"-----------------------------");
		}
		System.out.println(" ------------------ End Executing commands -----------------------------");
		
	}
	
	
	
}


