package Transaction;

import DB.AccountDB;
import DB.PayrollDB;
import Entity.EmployeeType;
import Address.*;

public class SpecificTransaction implements Transaction {
	
	private PayrollDB db = PayrollDB.getDB();
	
	private int id;
	private String address;
	private double amount;
	private int time;
	
	public SpecificTransaction(int id,String address,double amount,int time){
		this.id = id;
		this.address = address;
		this.amount = amount;
		this.time = time;
	}
	
	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		Address acc = AccountDB.getDB().get(address);
		if (acc instanceof BankAccount) {
			BankAccount bnkacc = (BankAccount) acc;
			bnkacc.transMoney(amount);
			db.delete(EmployeeType.Other, id);
		} else
			System.out.println("address should be bankaccount");

		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public boolean isTime2Pay(int time) {
		// TODO Auto-generated method stub
		return this.time == time;
	}
	
}
