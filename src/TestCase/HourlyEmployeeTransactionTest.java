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
import Entity.TimeCard;
import Transaction.EmployeeTransaction;
import Transaction.HourlyEmployeeTransaction;

public class HourlyEmployeeTransactionTest {

	private static final double TOL = 1.0E-6;
	
	@Test
	public void testExecute() {
		AccountDB bankDB = AccountDB.getDB();
		EmployeeDB empDB = EmployeeDB.getDB();
		PayrollDB payrollDB = PayrollDB.getDB();
//		EmployeeTransaction trans = new HourlyEmployeeTransaction(1,"home","Nico",300);
//		EmployeeTransaction trans2 = new HourlyEmployeeTransaction(1,"home","Nico",600);
		
		Command addEmpCMD = new AddEmployeeTransaction();
		addEmpCMD.input("name=Nico id=1 address=@home type=H money=salary>300");
		addEmpCMD.exec();
		
		empDB.get(1).addTimeCard(TimeCard.create("20:30", "21:30"));
		
		payrollDB.getTransaction(EmployeeType.Hourly, 1).Execute();
		assertEquals(bankDB.get(empDB.get(1).getaddress()).getBalance(),300,TOL);
		
		Command chgEmpCMD = new ChangeEmployeeDetail();
		chgEmpCMD.input("id=1 type=H money=salary>600");
		chgEmpCMD.exec();
		
		payrollDB.getTransaction(EmployeeType.Hourly, 1).Execute();
		assertEquals(bankDB.get(empDB.get(1).getaddress()).getBalance(),900,TOL);
	}

}
