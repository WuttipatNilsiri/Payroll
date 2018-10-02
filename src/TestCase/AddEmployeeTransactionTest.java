package TestCase;



import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Command.AddEmployeeTransaction;
import Command.Command;

public class AddEmployeeTransactionTest {
	
	@Rule
	  public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testAddEmployeeTransaction() {
		Command testCmd = new AddEmployeeTransaction();
		testCmd.input("name=Rinne1 id=1 address=1 type=H money=salary>10");
		assertEquals(testCmd.isValid(),true);
		testCmd.exec();
		exception.expect(IllegalArgumentException.class);
		testCmd.input("id=1 address=1 type=H money=salary>10");
//		assertEquals(testCmd.isValid(),false);
	}
	
	@Test
	public void testAddEmployeeTransactionMissingArg() {
		Command testCmd = new AddEmployeeTransaction();
		exception.expect(IllegalArgumentException.class);
		testCmd.input("name=Rinne1");
		assertEquals(testCmd.isValid(),false);
	}
}
