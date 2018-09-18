import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BankAccountDB {
	
	private Map<String, BankAccount> mapAcc = new HashMap<String, BankAccount>();
	
	private static BankAccountDB db = null;
	
	public static BankAccountDB getDB() {
		if(db == null) {
			db = new BankAccountDB();
		}
		return db;
	}
	
	public void add(BankAccount acc) {
		mapAcc.put(acc.getID(), acc);
	}
	
	public BankAccount get(String id) {
		return mapAcc.get(id);
	}
	
	public Collection<BankAccount> getAllBankAcc() {
		return mapAcc.values();
	}
	
	public void delete(String id) {
		mapAcc.remove(id);
	}
}
