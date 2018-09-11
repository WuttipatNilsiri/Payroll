import java.util.HashMap;
import java.util.Map;

public class EmployeeDB {
	
	Map<Integer, Employee> mapEmp = new HashMap<Integer, Employee>();
	
	static EmployeeDB db = null;
	
	public static EmployeeDB getDB() {
		if(db == null) {
			db = new EmployeeDB();
		}
		return db;
	}
	
	public void add(Employee emp) {
		mapEmp.put(emp.getID(), emp);
	}
	
	public Employee get(int id) {
		return mapEmp.get(id);
	}
}
