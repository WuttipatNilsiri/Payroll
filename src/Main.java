
public class Main {
	
	static PayrollDB payrollDB = PayrollDB.getDB();
	static BankAccountDB bankAccountDB = BankAccountDB.getDB();
	static EmployeeDB employeeDB = EmployeeDB.getDB();
	
	public static void main(String[] a ) {
		Payroll payroll = new Payroll();
		payroll.build();
		Command test = new AddEmployeeTransaction();
		test.input("name=Rinne id=1 address=Urashima type=H money=10");
		System.out.println(test.isValid());
		test.exec();
		Command test2 = new ChageAdressTransaction();
		test2.input("id=1 bankAccount=2");
		test2.exec();
		Command test3 = new ChangeEmployeeType();
		test3.input("id=1 type=C money=10000_10");
		test3.exec();
		employeeDB.get(1).sell();
		employeeDB.get(1).sell();
		employeeDB.get(1).sell();
		
		payroll.run();
		
		
//		Payroll payroll = new Payroll();
//		payroll.build();
//		payroll.addEmployeeTransaction(1,"Rinne", "Urashima",EmployeeType.Salaried, "1000" );
//		payroll.addEmployeeTransaction(2,"Rinbe", "Urashima",EmployeeType.Hourly, "10" );
//		payroll.addEmployeeTransaction(3, "kuy", "aasd", EmployeeType.Commissioned, "1000 10");
//		employeeDB.get(3).sell();
//		employeeDB.get(3).sell();
//		employeeDB.get(3).sell();
//		
//		payroll.changeEmployee(3, EmployeeType.Hourly , "100");
//		payroll.changeEmployee(2, EmployeeType.Commissioned, "10000 100");
//		employeeDB.get(2).sell();
//		employeeDB.get(2).sell();
//		employeeDB.get(2).sell();
//		employeeDB.get(2).sell();
//		employeeDB.get(2).sell();
//		payroll.changeAddressTransaction(2, 4);
//		bankAccountDB.delete(2);
////		System.out.println(employeeDB.get(3).type.toString());
//		payroll.run();
	}
}
