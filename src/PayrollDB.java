import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PayrollDB {
	
	List<Transaction> listComissioned = new ArrayList<Transaction>();
	List<Transaction> listHourly = new ArrayList<Transaction>();
	List<Transaction> listSalaried = new ArrayList<Transaction>();
	
	Map<EmployeeType,List<Transaction>> mapQ = new HashMap<EmployeeType,List<Transaction>>();
	
	static PayrollDB db = null;
	
	private PayrollDB() {
		mapQ.put(EmployeeType.Salaried, listSalaried);
		mapQ.put(EmployeeType.Hourly, listHourly);
		mapQ.put(EmployeeType.Commissioned, listComissioned);
	}
	
	public static PayrollDB getDB() {
		if (db == null) {
			db = new PayrollDB();
		}
		return db;
	}
	
	public void addTransaction(Transaction t,EmployeeType type) {
		mapQ.get(type).add(t);
	}
	
	public void trans(EmployeeType type) {
		for (Transaction t : mapQ.get(type)) {
			t.Execute();
		}
	}
	
	
}
