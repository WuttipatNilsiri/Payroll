package TestCase;

import static org.junit.Assert.*;

import org.junit.Test;

import Entity.Employee;
import Entity.EmployeeType;
import Entity.Sales;

public class EmployeeTest {
	
	private static final double TOL = 1.0E-6;

	@Test
	public void test() {
		Employee acc = new Employee(1, "James" ,"001");
		assertEquals(acc.get_Num_Sell_Item(),0,TOL);
		assertEquals(acc.getaddress(),"001");
		assertEquals(acc.getID(),1,TOL);
		assertEquals(acc.getName(),"James");
		assertEquals(acc.getType(),EmployeeType.Unknown);
		Sales s = new Sales();
		s.add("d");
		acc.addsales(s);
		acc.setType(EmployeeType.Hourly);
		assertEquals(acc.getType(),EmployeeType.Hourly);
		assertEquals(acc.get_Num_Sell_Item(),1,TOL);
		acc.resetSales();
		assertEquals(acc.get_Num_Sell_Item(),0,TOL);
	}

}
