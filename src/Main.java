
public class Main {
	
	static PayrollDB payrollDB = PayrollDB.getDB();
	static BankAccountDB bankAccountDB = BankAccountDB.getDB();
	static EmployeeDB employeeDB = EmployeeDB.getDB();
	
	public static void main(String[] a ) {
		
		Command c = CommandParser.create("addEmp:name=Rinne1 id=1 address=1 type=H money=salary>10");
		Command c1 = CommandParser.create("addEmp:name=Rinne2 id=2 address=2 type=H money=salary>100");
		Command c2 = CommandParser.create("addEmp:name=Rinne3 id=3 address=3 type=C money=rate>10,salary>10000");
		Command c3 = CommandParser.create("chgAdd:id=1 address=4");
		c.exec();
		c1.exec();
		c2.exec();
		c3.exec();
		
		employeeDB.get(3).sell();
		employeeDB.get(3).sell();
		employeeDB.get(3).sell();
		
		
		Payroll.getSystem().run();
		
//		Payroll payroll = new Payroll();
//		payroll.build();
		
//		Command addEmpCMD = new AddEmployeeTransaction();
//		
//		addEmpCMD.input("name=Rinne1 id=1 address=1 type=H money=salary>10");
////		System.out.println(test.isValid());
//		addEmpCMD.exec();
////		System.out.println(test.isValid());
////		
//		addEmpCMD.input("name=Rinne2 id=3 address=3 type=H money=salary>100");
//		addEmpCMD.exec();
//		
//		addEmpCMD.input("name=Rinne3 id=4 address=4 type=H money=salary>1000");
//		addEmpCMD.exec();
//		
//		Command ChgAddCMD = new ChageAdressTransaction();
//		ChgAddCMD.input("chgAdd:id=1 address=5");
//		ChgAddCMD.exec();
//		
//		Command ChgEmpTypeCMD = new ChangeEmployeeType();
//		ChgEmpTypeCMD.input("id=1 type=C money=rate>10,salary>10000");
//		ChgEmpTypeCMD.exec();
//		
//		Command DltEmpCMD = new DeleteEmployee();
////		test4.input("id=1");
////		test4.exec();
////		System.out.println(test4.isValid());
//		
//		employeeDB.get(1).sell();
//		employeeDB.get(1).sell();
//		employeeDB.get(1).sell();
//		
//		
//		
//		Payroll.getSystem().run();
		
		
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
