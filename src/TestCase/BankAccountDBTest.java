package TestCase;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import Address.Address;
import Address.BankAccount;
import DB.AccountDB;

public class BankAccountDBTest {
	
	private static final double TOL = 1.0E-6;
	
	@Test
	public void testBankAccountDBSingleton() {
		AccountDB test = AccountDB.getDB();
		AccountDB test2 = AccountDB.getDB();
		assertEquals(test,test2);
		
	}
	
	@Test
	public void testBankAccountAddAccount() {
		AccountDB test = AccountDB.getDB();
		BankAccount acc = new BankAccount("001", "James");
		BankAccount acc2 = new BankAccount("002", "Jimmy");
		test.add(acc);
		test.add(acc2);
		assertEquals(test.get("001"), acc);
		assertEquals(test.get("001").getClass(), acc.getClass());
		assertEquals(test.get("001").getID(), acc.getID());
		assertEquals(test.get("001").getName(), acc.getName());
		assertEquals(test.get("001").getBalance(), acc.getBalance(),TOL);
		assertEquals(test.get("002"), acc2);
	}
	
	@Test
	public void testBankAccountDeleteAccount() {
		AccountDB test = AccountDB.getDB();
		BankAccount acc = new BankAccount("001", "James");
		test.add(acc);
		assertNotEquals(test.get("001"), null);
		assertEquals(test.get("001"), acc);
		test.delete(acc.getID());
		assertEquals(test.get("001"), null);
		
	}
	
	@Test
	public void testBankAccountDBCollection() {
		AccountDB test = AccountDB.getDB();
		test.clear();
		Map<String, BankAccount> mapAcc = new HashMap<String, BankAccount>();
		BankAccount acc = new BankAccount("001", "James");
		BankAccount acc2 = new BankAccount("002", "Jimmy");
		mapAcc.put(acc.getID(), acc);
		mapAcc.put(acc2.getID(), acc2);
		test.add(acc);
		test.add(acc2);
		for (Address add : test.getAllBankAcc()) {
			assertEquals(mapAcc.get(add.getID()),add);
		}
		
		
		
	}

}
