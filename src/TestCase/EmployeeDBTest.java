package TestCase;

import static org.junit.Assert.*;

import org.junit.Test;

import DB.EmployeeDB;
import Entity.Employee;

public class EmployeeDBTest {
	
	@Test
	public void testEmployeeDBSingleton() {
		EmployeeDB test = EmployeeDB.getDB();
		EmployeeDB test2 = EmployeeDB.getDB();
		assertEquals(test,test2);
		
	}
	
	@Test
	public void testEmployeeDBAdd() {
		EmployeeDB test = EmployeeDB.getDB();
		Employee acc = new Employee(1, "James" ,"001");
		Employee acc2 = new Employee(2, "Jimmy" ,"002");
		test.add(acc);
		test.add(acc2);
		assertEquals(test.get(1), acc);
		assertEquals(test.get(1).getClass(), acc.getClass());
		assertEquals(test.get(1).getID(), acc.getID());
		assertEquals(test.get(1).getName(), acc.getName());
		assertEquals(test.get(2), acc2);
	}
	
	@Test
	public void testEmployeeDBDelete() {
		EmployeeDB test = EmployeeDB.getDB();
		Employee acc = new Employee(1, "James" ,"001");
		test.add(acc);
		assertNotEquals(test.get(1), null);
		assertEquals(test.get(1), acc);
		test.delete(acc.getID());
		assertEquals(test.get(1), null);
		
	}
	
}
