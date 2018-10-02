package TestCase;

import static org.junit.Assert.*;

import org.junit.Test;

import Entity.EmployeeType;

public class EmployeeTypeTest {
	
	private static final double TOL = 1.0E-6;

	@Test
	public void testEmployeeType() {
		EmployeeType unknown = EmployeeType.Unknown;
		EmployeeType hourly = EmployeeType.Hourly;
		EmployeeType commissioned = EmployeeType.Commissioned;
		EmployeeType salary = EmployeeType.Salaried;
		
		assertEquals(unknown.getTime2Pay(),0,TOL);
		assertEquals(hourly.getTime2Pay(),60,TOL);
		assertEquals(commissioned.getTime2Pay(),180,TOL);
		assertEquals(salary.getTime2Pay(),180,TOL);
		
	}

}
