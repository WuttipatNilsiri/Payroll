package TestCase;

import static org.junit.Assert.*;

import org.junit.Test;

import Address.BankAccount;

public class BankAccountTest {
	
	private static final double TOL = 1.0E-6;

	@Test
	public void testCreateBankAccount() {
		BankAccount account1 = new BankAccount("001", "James"); 
		assertNotEquals(account1,null);
		assertEquals(account1.getID(),"001");
		assertEquals(account1.getName(),"James");
		assertEquals(account1.getBalance(),0.0, TOL);
	}
	
	@Test
	public void testBankAccountTransfer() {
		BankAccount account1 = new BankAccount("001", "James"); 
		assertEquals(account1.getBalance(),0.0, TOL);
		account1.transMoney(300);
		assertEquals(account1.getBalance(),300, TOL);
		assertNotEquals(account1.getBalance(),0.0, TOL);
		account1.transMoney(20);
		assertEquals(account1.getBalance(),320, TOL);
	}
	
	@Test
	public void testBankAccountToString() {
		BankAccount account1 = new BankAccount("001", "James"); 
		assertEquals(account1.getBalance(),0.0, TOL);
		account1.transMoney(300);
		assertEquals(account1.toString(),"bank-id=001 name=James bal=300.00");
	}

}
