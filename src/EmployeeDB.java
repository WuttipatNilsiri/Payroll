import java.util.HashMap;
import java.util.Map;

public class EmployeeDB {
	
	private Map<Integer, Employee> mapEmp = new HashMap<Integer, Employee>();
	
	private static EmployeeDB db = null;
	
	public static EmployeeDB getDB() {
		if(db == null) {
			db = new EmployeeDB();
		}
		return db;
	}
	
	public void add(Employee emp) {
		mapEmp.put(emp.getID(), emp);
	}
	
	public void delete(int id) {
		mapEmp.remove(id);
	}
	
	public Employee get(int id) {
		if (mapEmp.containsKey(id)){
			return mapEmp.get(id);
		}
		return null;
	}
}
