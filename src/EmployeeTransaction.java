
public abstract class EmployeeTransaction implements Transaction {
	
	protected int id;
	private String address;
	private String name;
	
	protected EmployeeDB empDB = EmployeeDB.getDB();
	
	protected BankAccountDB bankDB = BankAccountDB.getDB();
	
	public EmployeeTransaction(int id, String address, String name) {
		this.id = id;
		this.address = address;
		this.name = name;
	}
	
	public abstract void Execute();
	
	
	public int getID() {
		return id;
	}
}
