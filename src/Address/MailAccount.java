package Address;

import java.util.ArrayList;
import java.util.List;

public class MailAccount implements Address {
	
	private String id;
	private String name;
	private List<Double> checks = new ArrayList<Double>();
	
	public MailAccount(String id, String name) {
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return String.format("mail-id=%s name=%s #mail=%d bal=%.2f", id,name,checks.size(),totalBal());
	}
	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void send(double in) {
		checks.add(in);
	}
	
	public double totalBal() {
		double sum = 0;
		for (double u : checks) {
			sum = sum + u;
		}
		return sum;
	}
}
