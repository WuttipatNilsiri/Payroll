package DB;
import java.util.HashMap;

import java.util.Map;
import java.util.Set;

import Entity.EmployeeType;
import Transaction.Transaction;

public class PayrollDB {
	
	private Map<Integer,Transaction> listComissioned = new HashMap<Integer,Transaction>();
	private Map<Integer,Transaction> listHourly = new HashMap<Integer,Transaction>();
	private Map<Integer,Transaction> listSalaried = new HashMap<Integer,Transaction>();
	
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
	
	// Mapping from Type "exactly" time 2 pay
	public void trans(EmployeeType type) {
		for (Transaction t : mapQ.get(type).values()) {
			t.Execute();
		}
	}
	
	//Loop all list find what Transaction time 2 pay
//	public void transby(int time) {
//		for (Transaction t : mapTransaction.values()) {
//			if(t.isTime2Pay(time)) {
//				t.Execute();
//			}
//		}
//	}
	
	public void delete(EmployeeType e,int id) {
		mapQ.get(e).remove(id);
	}
	
	public Set<EmployeeType> getKey(){
		return mapQ.keySet();
		
	}
	
	
	
	
}
