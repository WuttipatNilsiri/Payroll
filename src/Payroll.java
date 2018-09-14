

public class Payroll {
	
	static PayrollDB payrollDB; 
	static BankAccountDB bankAccountDB;
	static EmployeeDB employeeDB;
	
	
	
	
	public void build() {
		if (payrollDB == null) payrollDB = PayrollDB.getDB();
		if (bankAccountDB == null) bankAccountDB = BankAccountDB.getDB();
		if (employeeDB == null) employeeDB = EmployeeDB.getDB();
	}
	
	
//	public static void main(String[] a) {
//		
//		
//		
//		addEmployee(1,"Rinne", "Urashima",EmployeeType.Salaried, "1000" );
//		addEmployee(2,"Rinbe", "Urashima",EmployeeType.Hourly, "10" );
//		addEmployee(3, "kuy", "aasd", EmployeeType.Commissioned, "1000 10");
//		employeeDB.get(3).sell();
//		employeeDB.get(3).sell();
//		employeeDB.get(3).sell();
//		changeEmployee(3, EmployeeType.Hourly , "100");
//		
//		
//		
//	}
	
	public void setPayrollDB(PayrollDB db){
		payrollDB = db;
	}
	
	public void setBankAccountDB(BankAccountDB db){
		bankAccountDB = db;
	}
	
	public void setEmployeeDB(EmployeeDB db) {
		employeeDB = db;
	}
	
	public void run() {
		int time = 0;
		while(true) {
			time++;
			System.out.println("Time="+time);
			
			for (EmployeeType e : payrollDB.getKey()) {
				if ( istimeToPay(time,e.getTime2Pay())  ) {
					payrollDB.trans(e);
				}
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
	
	public static void addEmployeeTransaction(int id, String name, String address,EmployeeType type, String money) {
		BankAccount A_BankAcc = new BankAccount(id, name);
		Employee A = new Employee(id, name, address, id);
		A.setType(type);
		bankAccountDB.add(A_BankAcc);
		employeeDB.add(A);
		payrollDB.addTransaction(createTransaction(A, money), type);
	}
	
	private static Transaction createTransaction(Employee emp, String moneystring ) {
		int id = emp.getID();
		String add = emp.getAddress();
		String name = emp.getName();
		EmployeeType type = emp.getType();
		
		String[] moneyStringSplit = moneystring.split("_");
		
		
		
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
	
	public static void changeAddressTransaction(int empid,int bankid) {
		Employee emp = employeeDB.get(empid);
		emp.setBankAccID(bankid);
		bankAccountDB.delete(bankid);
		bankAccountDB.add(new BankAccount(bankid, emp.getName()));
	}
	
	private boolean istimeToPay(int time, int time2pay) {
		return time % time2pay == 0;
	}
	
}
