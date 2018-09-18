
public class CommissionedEmployeeTransaction extends EmployeeTransaction {
	
	private double salary;
	
	private double commissionRATE;
	
	public CommissionedEmployeeTransaction(int id, String address, String name, double salary, double commissionRATE) {
		super(id, address, name);
		this.salary = salary;
		this.commissionRATE = commissionRATE;
	}

	@Override
	public void Execute() {
		Employee emp = empDB.get(id);
		bankDB.get( emp.getBankAccountID() ).transMoney( salary + (emp.get_Num_Sell_Item() * commissionRATE) );
		emp.reset_Num_Sell_Item();
	}
}
