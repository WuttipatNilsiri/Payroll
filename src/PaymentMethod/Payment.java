package PaymentMethod;

import DB.AccountDB;

public abstract class Payment implements PaymentMethod {
	
	protected AccountDB db = AccountDB.getDB();
	
	@Override
	public abstract void exec(String address,double amount);	
	
}
