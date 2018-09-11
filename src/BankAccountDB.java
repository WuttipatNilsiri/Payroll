import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankAccountDB {
	
	Map<Integer, BankAccount> mapAcc = new HashMap<Integer, BankAccount>();
	
	static BankAccountDB db = null;
	
	public static BankAccountDB getDB() {
		if(db == null) {
			db = new BankAccountDB();
		}
		return db;
	}
	
	public void add(BankAccount acc) {
		mapAcc.put(acc.getID(), acc);
	}
	
	public BankAccount get(int id) {
		return mapAcc.get(id);
	}
	
	public Collection<BankAccount> getAllBankAcc() {
		return mapAcc.values();
	}
	
	public void delete(int id) {
		mapAcc.remove(id);
	}
}