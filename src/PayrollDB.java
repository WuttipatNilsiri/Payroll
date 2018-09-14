import java.util.HashMap;

import java.util.Map;
import java.util.Set;

public class PayrollDB {
	
	Map<Integer,Transaction> listComissioned = new HashMap<Integer,Transaction>();
	Map<Integer,Transaction> listHourly = new HashMap<Integer,Transaction>();
	Map<Integer,Transaction> listSalaried = new HashMap<Integer,Transaction>();
	
	
	
	Map<EmployeeType, Map<Integer,Transaction> > mapQ = new HashMap<EmployeeType, Map<Integer,Transaction> >();
	
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
		mapQ.get(type).put(t.getID(), t);
	}
	
	public void trans(EmployeeType type) {
		for (Transaction t : mapQ.get(type).values()) {
			t.Execute();
		}
	}
	
	public void delete(EmployeeType e,int id) {
		mapQ.get(e).remove(id);
	}
	
	public Set<EmployeeType> getKey(){
		return mapQ.keySet();
		
	}
	
	
	
	
}
