
public class HourlyEmployeeTransaction extends EmployeeTransaction {
	
	private double hourlyRate;
	
	public HourlyEmployeeTransaction(int id, String address, String name, double hourlyRate) {
		super(id, address, name);
		this.hourlyRate = hourlyRate;
	}

	@Override
	public void Execute() {
		bankDB.get( empDB.get(id).getBankAccountID() ).transMoney(hourlyRate);
	}
	
	
}
