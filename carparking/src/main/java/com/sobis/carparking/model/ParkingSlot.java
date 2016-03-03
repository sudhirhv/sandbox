package com.sobis.carparking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;

/*@SqlResultSetMapping(
        name = "ParkingSlotMapping",
        entities = @EntityResult(
                entityClass = ParkingSlot.class,
                fields = {
                    @FieldResult(name = "id", column = "ps_id"),
                    @FieldResult(name = "fk_employee", column = "employeeId"),
                    @FieldResult(name = "parkingDate", column = "parkingDate")
                }
        )
)*/

@SqlResultSetMapping(name="ParkingSlotMapping", classes = {
	    @ConstructorResult(targetClass = ParkingSlotResult.class, 
	    columns = {
	    	@ColumnResult(name="ps_id"), 
	    	@ColumnResult(name="employeeId"),
	    	@ColumnResult(name="parkingDate", type=Date.class),
	    	@ColumnResult(name="employeeName")})
	})

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

	public ParkingSlot(String slotType, int slotPosition, boolean isAvailable) {
		super();
		this.slotType = slotType;
		this.slotPosition = slotPosition;
		this.isAvailable = isAvailable;
	}
	
	public ParkingSlot(String slotType) {
		super();
		this.slotType = slotType;
		this.slotPosition = slotPosition;
		this.isAvailable = isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}
