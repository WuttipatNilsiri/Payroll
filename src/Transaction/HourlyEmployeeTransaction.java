package Transaction;
import Entity.Employee;
import Entity.EmployeeType;

public class HourlyEmployeeTransaction extends EmployeeTransaction {
	
	private double hourlyRate;
	
	
	public HourlyEmployeeTransaction(int id, String address, String name, double hourlyRate) {
		super(id, address, name);
		this.hourlyRate = hourlyRate;
		type = EmployeeType.Hourly;
	}

	@Override
	public void Execute() {
		Employee emp = empDB.get(id);
//		System.out.println(emp.getHours());
		emp.getPaymentMethod().exec(emp.getaddress(), hourlyRate * emp.getHours());
	}
	
	
	
	
	
	
}
