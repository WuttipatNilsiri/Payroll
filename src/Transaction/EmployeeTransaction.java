package Transaction;
import DB.AccountDB;
import DB.EmployeeDB;
import Entity.EmployeeType;

public abstract class EmployeeTransaction implements Transaction {
	
	protected int id;
	protected String address;
	protected String name;
	
	protected EmployeeDB empDB = EmployeeDB.getDB();
	
	protected AccountDB bankDB = AccountDB.getDB();
	
	protected EmployeeType type = EmployeeType.Unknown;
	
	public EmployeeTransaction(int id, String address, String name) {
		this.id = id;
		this.address = address;
		this.name = name;
	}
	
	public abstract void Execute();
	
	
	public int getID() {
		return id;
	}
	
	public boolean isTime2Pay(int time) {
		return  time % type.getTime2Pay() == 0;
	}
}
