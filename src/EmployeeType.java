
public enum EmployeeType {
	
	Unknown(0),
	Hourly(60),
	Salaried(180),
	Commissioned(180);
	
	int time2pay;
	
	private EmployeeType(int time2pay){
		this.time2pay = time2pay;
	}
	
	public int getTime2Pay() {
		return time2pay;
	}
}
