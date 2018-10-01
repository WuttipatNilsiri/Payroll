package Lib;

import PaymentMethod.BankPayment;
import PaymentMethod.MailPayment;
import PaymentMethod.PaymentMethod;

public class PaymentFilter {
	
	public static PaymentMethod createby(String address) {
		
		if (address.contains("@")) {
			return new MailPayment();
		}
		if (Util.isNumeric(address)) {
			return new BankPayment();
		}
		
		return null;
		
		
	}
}
