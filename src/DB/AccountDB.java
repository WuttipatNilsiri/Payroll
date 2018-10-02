package DB;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import Address.Address;



public class AccountDB {
	
	private Map<String, Address> mapAcc = new HashMap<String,  Address>();
	
	private static AccountDB db = null;
	
	public static AccountDB getDB() {
		if(db == null) {
			db = new AccountDB();
		}
		return db;
	}
	
	public void add( Address acc) {
		mapAcc.put(acc.getID(), acc);
	}
	
	public  Address get(String id) {
		if (mapAcc.containsKey(id)){
			return mapAcc.get(id);
		}
		return null;
	}
	
	public boolean find(String id) {
		return mapAcc.containsKey(id);
	}
	
	public Collection<Address> getAllBankAcc() {
		return mapAcc.values();
	}
	
	public void delete(String id) {
		mapAcc.remove(id);
	}
	public void clear() {
		mapAcc.clear();
	}
}
