import java.util.EnumMap;

public class Main {
	
	static PayrollDB payrollDB = PayrollDB.getDB();
	static BankAccountDB bankAccountDB = BankAccountDB.getDB();
	static EmployeeDB employeeDB = EmployeeDB.getDB();
	
	public static void main(String[] a) {
		
		int time = 0;
		
		addEmployee(1,"Rinne", "Urashima",EmployeeType.Salaried, "1000" );
		addEmployee(2,"Rinbe", "Urashima",EmployeeType.Hourly, "10" );
		addEmployee(3, "kuy", "aasd", EmployeeType.Commissioned, "1000 10");
		employeeDB.get(3).sell();
		employeeDB.get(3).sell();
		employeeDB.get(3).sell();
		changeEmployee(3, EmployeeType.Hourly , "100");
		
		while(true) {
			time++;
			System.out.println("Time="+time);
			if (time % 60 == 0) {
				payrollDB.trans(EmployeeType.Hourly);
			}
			if (time % (60*3) == 0) {
				payrollDB.trans(EmployeeType.Salaried);
				payrollDB.trans(EmployeeType.Commissioned);
			}
			
			for (BankAccount acc : BankAccountDB.getDB().getAllBankAcc()) {
				System.out.println("id="+acc.getID()+" bal="+acc.getBalance());
			}
			
			System.out.println("--------------");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void addEmployee(int id, String name, String address,EmployeeType type, String money) {
		BankAccount A_BankAcc = new BankAccount(id, name);
		Employee A = new Employee(id, name, address, id);
		A.setType(type);
		bankAccountDB.add(A_BankAcc);
		employeeDB.add(A);
		payrollDB.addTransaction(createTransaction(A, money), type);
	}
	
	public static Transaction createTransaction(Employee emp, String moneystring ) {
		int id = emp.getID();
		String add = emp.getAddress();
		String name = emp.getName();
		EmployeeType type = emp.getType();
		
		String[] moneyStringSplit = moneystring.split(" ");

		
		try {
			double salary = Double.parseDouble(moneyStringSplit[0]);
			
			if (type == EmployeeType.Commissioned) {
				double rate = 0;
				try {
					
					rate = Double.parseDouble(moneyStringSplit[1]);
					return new CommissionedEmployeeTransaction(id, name, add, salary, rate);
				
				} catch(IndexOutOfBoundsException e) {
					throw new IllegalArgumentException("need at least TWO arg for CommissionedEmployee");
				}
				
				
			}
			
			if (type == EmployeeType.Salaried) {
				return new SalariedEmployeeTransaction(id, add, name, salary);
			}
			
			if (type == EmployeeType.Hourly) {
				return new SalariedEmployeeTransaction(id, add, name, salary);
			}
		} catch(IndexOutOfBoundsException e) {
			throw new IllegalArgumentException("need at least ONE arg");
		}
		
		
		
		
		return null;
	}
	
	public static void deleteEmployee(int id) {
		Employee emp = employeeDB.get(id);
		bankAccountDB.delete(emp.getBankAccountID());
		payrollDB.delete(emp.getType(), emp.getID());
		employeeDB.delete(id);	
	}
	
	public static void changeEmployee(int id, EmployeeType type,String money) {
		Employee emp = employeeDB.get(id);
		payrollDB.delete(emp.getType(), emp.getID());
		emp.setType(type);
		payrollDB.addTransaction(createTransaction(emp, money), type);
	}
	
}
