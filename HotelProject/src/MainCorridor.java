import java.util.HashSet;
import java.util.Set;




public class MainCorridor extends Corridor implements CorridorInterface {
	
	public final static String type = "main";
	private Set<Light> lights = new HashSet<Light>();
	private Set<AC> acs = new HashSet<AC>();
		
	public MainCorridor(int noOfLights, int noOfAcs) {
		
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
		System.out.println(acs.size());
		for (AC ac : acs) {
			System.out.println("in set");
			ac.setState(true);
		}
		for (Light light : lights) {
			light.setState(true);
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
		// TODO Auto-generated method stub
		return 0;
	}	
}
