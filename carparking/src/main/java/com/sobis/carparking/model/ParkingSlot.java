package com.sobis.carparking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="parkingSlot")
public class ParkingSlot extends Base {
	
	@Column(name="slotType")
	private String slotType;
	
	@Column(name="slotPosition")
	private int slotPosition;
	
	@Column(name="isAvailable")
	private boolean isAvailable;

	public ParkingSlot(){
		
	}
	
	public String getSlotType() {
		return slotType;
	}

	public void setSlotType(String slotType) {
		this.slotType = slotType;
	}

	public int getSlotPosition() {
		return slotPosition;
	}

	public void setSlotPosition(int slotPosition) {
		this.slotPosition = slotPosition;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}
