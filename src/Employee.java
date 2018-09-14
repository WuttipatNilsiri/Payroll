
public class Employee {
	
	int id;
	String address;
	String name;
	int bankAccountID;
	
	int  num_sell_Item = 0;
	
	EmployeeType type = EmployeeType.Unknown;
	
	public Employee(int id, String name, String address, int bankAccountID){
		this.id = id;
		this.name = name;
		this.address = address;
		this.bankAccountID = bankAccountID;
	}
	
	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public int getBankAccountID() {
		return bankAccountID;
	}
	
	public void setType(EmployeeType type) {
		this.type = type;
	}
	
	public void setBankAccID(int id) {
		bankAccountID = id;
	}
	
	public EmployeeType getType() {
		return type;
	}
	
	public void sell() {
		num_sell_Item++;
	}
	
	public int get_Num_Sell_Item() {
		return num_sell_Item;
	}
	
	public void reset_Num_Sell_Item() {
		num_sell_Item = 0;
	}
	
	
	
}
