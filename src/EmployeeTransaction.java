
public abstract class EmployeeTransaction implements Transaction {
	
	int id;
	String address;
	String name;
	
	EmployeeDB empDB = EmployeeDB.getDB();
	
	BankAccountDB bankDB = BankAccountDB.getDB();
	
	public EmployeeTransaction(int id, String address, String name) {
		this.id = id;
		this.address = address;
		this.name = name;
	}
	
	public abstract void Execute();
	
}
