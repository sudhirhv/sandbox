import java.util.HashSet;
import java.util.Set;


public class Floor implements FloorInterface {
	
	private int floorNo;
	
	private Set<MainCorridor> mainCorridors = new HashSet<MainCorridor>();
	private Set<SubCorridor> subCorridors = new HashSet<SubCorridor>();
	
	public Floor(Set<MainCorridor> mainCorridors, Set<SubCorridor> subCorridors, int floorNo) {
		this.setMainCorridors(mainCorridors);
		this.setSubCorridors(subCorridors);
		this.floorNo = floorNo;
	}
	
	@Override
	public int getPowerConsumption() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNoOfMainCorridors() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNoOfSubCorridors() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Set<MainCorridor> getMainCorridors() {
		return mainCorridors;
	}

	public void setMainCorridors(Set<MainCorridor> mainCorridors) {
		this.mainCorridors = mainCorridors;
	}

	public Set<SubCorridor> getSubCorridors() {
		return subCorridors;
	}

	public void setSubCorridors(Set<SubCorridor> subCorridors) {
		this.subCorridors = subCorridors;
	}

	public int getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}
	
	
	
	
}
