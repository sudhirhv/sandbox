package com.hotel.src;
import java.util.Date;


public class Light  {
	
	public static final int powerConsumedByLight = 5;
	
	private Date lightDate;	
	private int lightNo;
	private boolean state;

	public int getLightNo() {
		return lightNo;
	}

	public void setLightNo(int lightNo) {
		this.lightNo = lightNo;
	}
	
	public Date getLightDate() {
		return lightDate;
	}

	public void setLightDate(Date lightDate) {
		this.lightDate = lightDate;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}	
	
}
