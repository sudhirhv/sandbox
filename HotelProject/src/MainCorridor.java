import java.util.HashSet;
import java.util.Set;

public class MainCorridor extends Corridor {	
	
	private static final String nightTimeStart = "06:00PM";
	private static final String nightTimeEnd = "06:00AM";
	public static final int powerCapAt = 10;
	
	public MainCorridor(int noOfLights, int noOfAcs) {
		super(noOfLights, noOfAcs);
	}
	public static String getNighttimestart() {
		return nightTimeStart;
	}
	public static String getNighttimeend() {
		return nightTimeEnd;
	}
	
}
