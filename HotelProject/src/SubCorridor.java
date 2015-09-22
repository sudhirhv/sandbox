import java.util.HashSet;
import java.util.Set;


public class SubCorridor extends Corridor implements CorridorInterface {
	public final static String type = "sub";
	
	private Set<Light> lights = new HashSet<Light>();
	private Set<AC> acs = new HashSet<AC>(); 
	
	public SubCorridor(int noOfLights, int noOfAcs) {
		
		for (int i = 0; i < noOfLights; i++) {
			Light light = new Light();
			light.setLightNo(i);
			lights.add(light);
		}
		for (int j = 0; j < noOfAcs; j++) {
			AC ac = new AC();
			ac.setAcNo(j);
			acs.add(ac);
			
		}
		this.setDefaultState();
	}	
	
	public void setDefaultState() {
		for (AC ac : acs) {
			ac.setState(true);
		}
		for (Light light : lights) {
			light.setState(false);
		}
	}
	
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

	@Override
	public String getTypeOfCorridor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalPowerConsumption(Corridor corridor) {
		int powerConsumed = 0;
		
		for (AC ac : corridor.getAcs()) {
			powerConsumed = ac.isState() ? powerConsumed + 10 : powerConsumed + 0;
		}
		
		for (Light light : corridor.getLights()) {
			powerConsumed = light.isState() ? powerConsumed + 5 : powerConsumed + 0;
		}				
		return powerConsumed;
	}
}
