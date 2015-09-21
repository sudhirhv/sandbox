import java.util.HashSet;
import java.util.Set;


public class Hotel {
	
	private Set<Floor> floors = new HashSet<Floor>();
	private int powerConsumption;	
	
	public Hotel(Set<Floor> floors) {
		System.out.println("size "+floors.size());
		this.setFloors(floors);
	}
	
	
	public int getPowerConsumption() {
		return powerConsumption;
	}
	public void setPowerConsumption(int powerConsumption) {
		this.powerConsumption = powerConsumption;
	}


	public Set<Floor> getFloors() {
		return floors;
	}


	public void setFloors(Set<Floor> floors) {
		this.floors = floors;
	}	
	
	
	
}
