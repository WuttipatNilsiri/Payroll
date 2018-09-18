
public class BankAccount {
	
	private String id;
	private String name;
	private double bal;
	
	public BankAccount(String id, String name){
		this.id = id;
		this.name = name;
		bal = 0.0;
	}
	
	public String getID() {
		return id;
	}
	
	public void transMoney(double amount) {
		bal = bal + amount;
//		System.out.println("id="+id+" " + bal);
	}
	
	public double getBalance() {
		return bal;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return String.format("bankid=%s name=%s bal=%.2f", id,name,bal);
	}
}
