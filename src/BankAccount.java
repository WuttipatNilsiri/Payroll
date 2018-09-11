
public class BankAccount {
	int id;
	String name;
	double bal;
	
	public BankAccount(int id, String name){
		this.id = id;
		this.name = name;
		bal = 0.0;
	}
	
	public int getID() {
		return id;
	}
	
	public void transMoney(double amount) {
		bal = bal + amount;
//		System.out.println("id="+id+" " + bal);
	}
}
