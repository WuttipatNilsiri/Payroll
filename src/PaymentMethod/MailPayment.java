package PaymentMethod;

import Address.MailAccount;

public class MailPayment extends Payment {

	@Override
	public void exec(String address,double amount) {
		if( db.get(address) instanceof MailAccount) {
			MailAccount acc = (MailAccount) db.get(address);
			acc.send(amount);
		}
	}
	
}
