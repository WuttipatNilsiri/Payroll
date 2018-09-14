import java.util.Map;

public class Util {
	
	public static boolean isValueValid(Map<String,String> a,String key) {
		
		if (!a.containsKey(key)) {
			return false;
		}
		
		if (a.get(key) != null) {
			return true;
		}
		
		return false;
		
	}
	
	public static EmployeeType char2type(String in) {
		if (in.equals("H")) {
			return EmployeeType.Hourly;
		}
		
		if (in.equals("C")) {
			return EmployeeType.Commissioned;
		}
		
		if (in.equals("S")) {
			return EmployeeType.Salaried;
		}
		
		return EmployeeType.Unknown;
	}
}
