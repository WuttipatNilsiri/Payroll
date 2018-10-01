package Address;

public class BankAccount implements Address {
	
	
	private String id;
	private String name;
	private double bal;
	
	public BankAccount(String id, String name){
		this.id = id;
		this.name = name;
		bal = 0.0;
	}
	

	public void transMoney(double amount) {
		bal = bal + amount;
	}
	
	public String getID() {
		return id;
	}
	
	public double getBalance() {
		return bal;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return String.format("bank-id=%s name=%s bal=%.2f", id,name,bal);
	}
}
