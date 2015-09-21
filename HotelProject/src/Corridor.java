import java.util.Set;


public class Corridor {
	
	private Set<Light> lights;
	private Set<AC> acs;
	private int corridorNo;
	
	public Set<Light> getLights() {
		return lights;
	}

	public void setLights(Set<Light> lights) {
		this.lights = lights;
	}

	public Set<AC> getAcs() {
		return acs;
	}

	public void setAcs(Set<AC> acs) {
		this.acs = acs;
	}

	public int getCorridorNo() {
		return corridorNo;
	}

	public void setCorridorNo(int corridorNo) {
		this.corridorNo = corridorNo;
	}
	
}
