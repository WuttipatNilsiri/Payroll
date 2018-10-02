package TestCase;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import Command.AddEmployeeTransaction;
import Command.Command;
import DB.AccountDB;
import DB.EmployeeDB;
import DB.PayrollDB;
import Entity.EmployeeType;
import Entity.TimeCard;
import Transaction.EmployeeTransaction;
import Transaction.HourlyEmployeeTransaction;
import Transaction.SalariedEmployeeTransaction;
import Transaction.Transaction;

public class PayrollDBTest {
	
	private static final double TOL = 1.0E-6;
	private Map<Integer,Transaction> listComissioned = new HashMap<Integer,Transaction>();
	private Map<Integer,Transaction> listHourly = new HashMap<Integer,Transaction>();
	private Map<Integer,Transaction> listSalaried = new HashMap<Integer,Transaction>();
	Map<EmployeeType, Map<Integer,Transaction> > mapQTest = new HashMap<EmployeeType, Map<Integer,Transaction> >();
	
	
	@Before
    public void setUp(){
		mapQTest.put(EmployeeType.Salaried, listSalaried);
		mapQTest.put(EmployeeType.Hourly, listHourly);
		mapQTest.put(EmployeeType.Commissioned, listComissioned);
    }

	@Test
	public void testAddTransaction() {
		PayrollDB db = PayrollDB.getDB();
		EmployeeTransaction trans = new HourlyEmployeeTransaction(1,"home","Nico",300);
		EmployeeTransaction trans2 = new SalariedEmployeeTransaction(1,"home","Nico",1000);
		db.addTransaction(trans, EmployeeType.Hourly);
		db.addTransaction(trans2, EmployeeType.Salaried);
		mapQTest.get(EmployeeType.Hourly).put(trans.getID(), trans);
		mapQTest.get(EmployeeType.Salaried).put(trans2.getID(), trans2);
		assertEquals(mapQTest.get(EmployeeType.Hourly),db.getMap().get(EmployeeType.Hourly));
		assertEquals(mapQTest.get(EmployeeType.Salaried),db.getMap().get(EmployeeType.Salaried));
	}
	
	@Test
	public void testTransMethod() {
		AccountDB bankDB = AccountDB.getDB();
		EmployeeDB empDB = EmployeeDB.getDB();
		
		Command addEmpCMD = new AddEmployeeTransaction();
		PayrollDB db = PayrollDB.getDB();
		
		addEmpCMD.input("name=Nico id=1 address=@home type=H money=salary>300");
		addEmpCMD.exec();
		empDB.get(1).addTimeCard(TimeCard.create("20:30", "22:30"));
		db.trans(EmployeeType.Hourly);
		assertEquals(bankDB.get(empDB.get(1).getaddress()).getBalance(),600,TOL);
	}
	
	@Test
	public void testDeleteTransaction() {
		PayrollDB db = PayrollDB.getDB();
		EmployeeTransaction trans = new HourlyEmployeeTransaction(1,"home","Nico",300);
		EmployeeTransaction trans2 = new SalariedEmployeeTransaction(1,"home","Nico",1000);
		db.addTransaction(trans, EmployeeType.Hourly);
		db.addTransaction(trans2, EmployeeType.Salaried);
		db.delete(EmployeeType.Hourly, 1);
		db.delete(EmployeeType.Salaried, 1);
		assertEquals(mapQTest.get(EmployeeType.Hourly),db.getMap().get(EmployeeType.Hourly));
		assertEquals(mapQTest.get(EmployeeType.Salaried),db.getMap().get(EmployeeType.Salaried));
			
	}
	
	
	

}
