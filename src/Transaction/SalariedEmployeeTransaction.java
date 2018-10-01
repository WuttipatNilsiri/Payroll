package Transaction;
import Entity.Employee;
import Entity.EmployeeType;

public class SalariedEmployeeTransaction extends EmployeeTransaction {
	
	private double salary;
	
	public SalariedEmployeeTransaction(int id, String address, String name, double salary) {
		super(id, address, name);
		this.salary = salary;
		type = EmployeeType.Salaried;
	}

	@Override
	public void Execute() {
		Employee emp = empDB.get(id);
		emp.getPaymentMethod().exec(emp.getaddress(),salary);
	}
}
