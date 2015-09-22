package com.sudhir.corridor;


public class SubCorridor extends Corridor implements CorridorInterface  {
	
	public static final int powerCapAt = 10;
	
	public SubCorridor(int noOfLights, int noOfAcs) {		
		super(noOfLights, noOfAcs);		
	}
	
}
