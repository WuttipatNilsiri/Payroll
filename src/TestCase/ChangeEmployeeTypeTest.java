package TestCase;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Command.AddEmployeeTransaction;
import Command.ChangeEmployeeType;
import Command.Command;

public class ChangeEmployeeTypeTest {
	
	@Rule
	  public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testChangeEmployeeType() {
		Command addEmpCMD = new AddEmployeeTransaction();	
		Command ChgTypeCMD = new ChangeEmployeeType();
		addEmpCMD.input("name=Rinne1 id=1 address=1 type=H money=salary>10");
		addEmpCMD.exec();
		ChgTypeCMD.input("id=1 type=C money=rate>10,salary>100002");
		assertEquals(ChgTypeCMD.isValid(),true);
		ChgTypeCMD.exec();
		
		
	}
	
	@Test
	public void testChangeEmployeeTypeMissingArg() {
		Command addEmpCMD = new AddEmployeeTransaction();	
		Command ChgTypeCMD = new ChangeEmployeeType();
		addEmpCMD.input("name=Rinne1 id=1 address=1 type=H money=salary>10");
		addEmpCMD.exec();
		exception.expect(IllegalArgumentException.class);
		ChgTypeCMD.input("id=1 money=rate>10,salary>10000");
		assertEquals(ChgTypeCMD.isValid(),false);
		
	}
}
