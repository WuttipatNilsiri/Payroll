package TestCase;

import static org.junit.Assert.*;

import org.junit.Test;

import Command.AddEmployeeTransaction;
import Command.ChangeEmployeeDetail;
import Command.Command;
import DB.AccountDB;
import DB.EmployeeDB;
import DB.PayrollDB;
import Entity.EmployeeType;
import Transaction.EmployeeTransaction;
import Transaction.SalariedEmployeeTransaction;

public class SalariedEmployeeTransactionTest {
	
	private static final double TOL = 1.0E-6;
	
	@Test
	public void test() {
		AccountDB bankDB = AccountDB.getDB();
		EmployeeDB empDB = EmployeeDB.getDB();
		
		Command addEmpCMD = new AddEmployeeTransaction();
		addEmpCMD.input("name=Nico id=1 address=@home type=S money=salary>1000");
		addEmpCMD.exec();
		PayrollDB.getDB().getTransaction(EmployeeType.Salaried, 1).Execute();
		
		assertEquals(bankDB.get(empDB.get(1).getaddress()).getBalance(),1000,TOL);
		
		Command chgcmd = new ChangeEmployeeDetail();
		chgcmd.input("id=1 type=S money=salary>3000");
		chgcmd.exec();
		PayrollDB.getDB().getTransaction(EmployeeType.Salaried, 1).Execute();
		
		assertEquals(bankDB.get(empDB.get(1).getaddress()).getBalance(),4000,TOL);
	}

}
