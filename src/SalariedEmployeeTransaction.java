
public class SalariedEmployeeTransaction extends EmployeeTransaction {
	
	private double salary;
	
	public SalariedEmployeeTransaction(int id, String address, String name, double salary) {
		super(id, address, name);
		this.salary = salary;
	}

	@Override
	public void Execute() {
		bankDB.get( empDB.get(id).getBankAccountID() ).transMoney(salary);
	}
}
