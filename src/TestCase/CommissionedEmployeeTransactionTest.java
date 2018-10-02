package TestCase;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Command.AddEmployeeTransaction;
import Command.Command;
import DB.AccountDB;
import DB.EmployeeDB;
import Entity.Sales;
import Transaction.CommissionedEmployeeTransaction;
import Transaction.EmployeeTransaction;

public class CommissionedEmployeeTransactionTest {

	private static final double TOL = 1.0E-6;

	
	@Test
	public void testCommissionedEmployeeTransaction() {
		AccountDB bankDB = AccountDB.getDB();
		EmployeeDB empDB = EmployeeDB.getDB();
		EmployeeTransaction trans = new CommissionedEmployeeTransaction(1,"home","Nico",1000,300);
		Command addEmpCMD = new AddEmployeeTransaction();
		addEmpCMD.input("name=Nico id=1 address=@home type=C money=rate>10,salary>10000");
		addEmpCMD.exec();
		Sales s1 = new Sales();
		s1.add("S","A","B");
//		System.out.println(employeeDB.get(3).getName());
		empDB.get(1).addsales(s1);
		assertEquals(empDB.get(1).get_Num_Sell_Item(),3,TOL);
		trans.Execute();
		assertEquals(bankDB.get(empDB.get(1).getaddress()).getBalance(),1900,TOL);
		Sales s2 = new Sales();
		s2.add("S");
		empDB.get(1).addsales(s2);
		assertEquals(empDB.get(1).get_Num_Sell_Item(),1,TOL);
		EmployeeTransaction trans2 = new CommissionedEmployeeTransaction(1,"home","Nico",1000,600);
		trans2.Execute();
		assertEquals(bankDB.get(empDB.get(1).getaddress()).getBalance(),3500,TOL);
		
	}
	

}
