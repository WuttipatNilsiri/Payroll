package TestCase;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Command.AddEmployeeTransaction;
import Command.Command;
import Command.DeleteEmployee;

public class DeleteEmployeeTest {
	
	@Rule
	  public final ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testDeleteEmployee() {
		Command addEmpCMD = new AddEmployeeTransaction();	
		Command delete = new DeleteEmployee();
		addEmpCMD.input("name=Rinne1 id=1 address=1 type=H money=salary>10");
		addEmpCMD.exec();
		delete.input("id=1");
		assertEquals(delete.isValid(),true);
		delete.exec();
		exception.expect(NullPointerException.class);
		delete.input("id=1");
		delete.exec();
		
	}
	
	@Test
	public void testDeleteEmployeeWrongId() {
		Command addEmpCMD = new AddEmployeeTransaction();	
		Command delete = new DeleteEmployee();
		addEmpCMD.input("name=Rinne1 id=1 address=1 type=H money=salary>10");
		addEmpCMD.exec();
		delete.input("id=2");
		assertEquals(delete.isValid(),true);
		exception.expect(NullPointerException.class);
		delete.exec();
		
	}
	
}
