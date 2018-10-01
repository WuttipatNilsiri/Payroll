package Transaction;
import Entity.Employee;
import Entity.EmployeeType;

public class CommissionedEmployeeTransaction extends EmployeeTransaction {
	
	private double salary;
	
	private double commissionRATE;
	
	public CommissionedEmployeeTransaction(int id, String address, String name, double salary, double commissionRATE) {
		super(id, address, name);
		this.salary = salary;
		this.commissionRATE = commissionRATE;
		type = EmployeeType.Commissioned;
	}

	@Override
	public void Execute() {
		Employee emp = empDB.get(id);
		emp.getPaymentMethod().exec(emp.getaddress(), salary + (emp.get_Num_Sell_Item() * commissionRATE));
		emp.resetSales();
	}
}
