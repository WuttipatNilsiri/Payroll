package PaymentMethod;

import Address.BankAccount;

public class BankPayment extends Payment {

	@Override
	public void exec(String address,double amount) {
		if( db.get(address) instanceof BankAccount) {
			BankAccount acc = (BankAccount) db.get(address);
			acc.transMoney(amount);
		}
		else
			throw new IllegalArgumentException("Address not match: need to be BankAccount");
	}
	
}
