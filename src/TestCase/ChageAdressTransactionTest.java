package TestCase;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Command.AddEmployeeTransaction;
import Command.ChageAdressTransaction;
import Command.Command;

public class ChageAdressTransactionTest {
	@Rule
	  public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testChageAdressTransaction() {
		Command addEmpCMD = new AddEmployeeTransaction();	
		Command ChgAddCMD = new ChageAdressTransaction();
		addEmpCMD.input("name=Rinne1 id=1 address=1 type=H money=salary>10");
		addEmpCMD.exec();
		ChgAddCMD.input("id=1 address=2");
		assertEquals(ChgAddCMD.isValid(),true);
		ChgAddCMD.exec();
		
	}
	
	@Test
	public void testChageAdressTransactionMissingArg() {
		Command addEmpCMD = new AddEmployeeTransaction();	
		Command ChgAddCMD = new ChageAdressTransaction();
		addEmpCMD.input("name=Rinne1 id=1 address=1 type=H money=salary>10");
		addEmpCMD.exec();
		exception.expect(IllegalArgumentException.class);
		ChgAddCMD.input("address=2");
		assertEquals(ChgAddCMD.isValid(),false);
		
	}

}
