package System;
import java.util.HashMap;
import java.util.Map;

import DB.AccountDB;
import DB.EmployeeDB;
import DB.PayrollDB;
import Entity.Employee;
import Entity.EmployeeType;
import Lib.PaymentFilter;
import Lib.Util;
import Transaction.CommissionedEmployeeTransaction;
import Transaction.HourlyEmployeeTransaction;
import Transaction.SalariedEmployeeTransaction;
import Transaction.Transaction;
import Address.*;


public class Payroll {
	
	private static PayrollDB payrollDB; 
	private static AccountDB bankAccountDB;
	private static EmployeeDB employeeDB;
	
	private static Payroll payrollSystem;
	
	public Payroll() {
		build();
	}
	
	public void build() {
		if (payrollDB == null) payrollDB = PayrollDB.getDB();
		if (bankAccountDB == null) bankAccountDB = AccountDB.getDB();
		if (employeeDB == null) employeeDB = EmployeeDB.getDB();
	}
	
	public static Payroll getSystem() {
		if (payrollSystem == null) {
			payrollSystem = new Payroll();
		}
		return payrollSystem;
	}
	
	
//	public static void main(String[] a) {
//		
//		
//		
//		addEmployee(1,"Rinne", "Urashima",EmployeeType.Salaried, "1000" );
//		addEmployee(2,"Rinbe", "Urashima",EmployeeType.Hourly, "10" );
//		addEmployee(3, "kuy", "aasd", EmployeeType.Commissioned, "1000 10");
//		employeeDB.get(3).sell();
//		employeeDB.get(3).sell();
//		employeeDB.get(3).sell();
//		changeEmployee(3, EmployeeType.Hourly , "100");
//		
//		
//		
//	}
	
	public void setPayrollDB(PayrollDB db){
		payrollDB = db;
	}
	
	public void setBankAccountDB(AccountDB db){
		bankAccountDB = db;
	}
	
	public void setEmployeeDB(EmployeeDB db) {
		employeeDB = db;
	}
	
	public void run() {
		int time = 0;
		while(true) {
			time++;
			System.out.println("Time="+time);
			
			for (EmployeeType e : payrollDB.getKey()) {
				if ( istimeToPay(time,e.getTime2Pay())  ) {
					payrollDB.trans(e);
				}
			}
			
			for (Address acc : AccountDB.getDB().getAllBankAcc()) {
				System.out.println(acc.toString());
			}
			
			System.out.println("--------------");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void addEmployeeTransaction(int id, String name, String address,EmployeeType type, String money) {
		Employee emp = new Employee(id, name, address);
		Address acc = Util.createby(emp);
		emp.setType(type);
		bankAccountDB.add(acc);
		employeeDB.add(emp);
		payrollDB.addTransaction(createTransaction(emp, money), type);
	}
	
	private static Transaction createTransaction(Employee emp, String moneystring ) {
		int id = emp.getID();
		String add = emp.getaddress();
		String name = emp.getName();
		EmployeeType type = emp.getType();
		
		String[] moneyStringSplit = moneystring.split(",");
		
		Map<String,Double> moneyMap = new HashMap<String,Double>();
		
		for (String x : moneyStringSplit) {
			String[] spx = x.split(">");
			moneyMap.put(spx[0], Double.parseDouble(spx[1]));
		}
		
		double salary = 0.0;
		
		try {
			salary =  moneyMap.get("salary");
		}
		catch(Exception e){
			throw new IllegalArgumentException("not define salary");
		}
		
		if (type == EmployeeType.Commissioned) {
			
			double rate = 0.0;
			
			try {
				rate =  moneyMap.get("rate");
			}
			catch(Exception e){
				throw new IllegalArgumentException("not define rate for Commissioned Employee");
			}
			
			return new CommissionedEmployeeTransaction(id, name, add, salary, rate);	
			
		}
		
		if (type == EmployeeType.Salaried) {
			return new SalariedEmployeeTransaction(id, add, name, salary);
		}
		
		if (type == EmployeeType.Hourly) {
			return new HourlyEmployeeTransaction(id, add, name, salary);
		}
		
		
		
		
		
		
//		try {
//			double salary = 0.0;
//			
//			for (String x : moneyStringSplit) {
//				if (x.contains("salary")) {
//					salary = Double.parseDouble(x.replace("salary>", ""));
//					break;
//				}
//			}
//			
//			if (salary == 0.0) {
//				throw new Exception("not define salary");
//			}
//			
//			if (type == EmployeeType.Commissioned) {
//				double rate = 0;
//				try {
//					
//					for (String x : moneyStringSplit) {
//						if (x.contains("rate")) {
//							rate = Double.parseDouble(x.replace("rate>", ""));
//							break;
//						}
//					}
//					
//					if (rate == 0.0) {
//						throw new IllegalArgumentException("not define rate");
//					}
//					
////					rate = Double.parseDouble(moneyStringSplit[1].replace("rate>",""));
//					return new CommissionedEmployeeTransaction(id, name, add, salary, rate);
//				
//				} catch(IllegalArgumentException e) {
//					throw e;
//				}
//			}
//			
//			if (type == EmployeeType.Salaried) {
//				if (salary == 0.0) {
//					throw new Exception("not define salary");
//				}
//				return new SalariedEmployeeTransaction(id, add, name, salary);
//			}
//			
//			if (type == EmployeeType.Hourly) {
//				if (salary == 0.0) {
//					throw new Exception("not define salary");
//				}
//				return new SalariedEmployeeTransaction(id, add, name, salary);
//			}
//		} catch(Exception e) {
//			System.out.println(e.getMessage());
//			throw new IllegalArgumentException("Arg not OK");
//		}
//		
		
		
		
		return null;
	}
	
	public void deleteEmployee(int id) {
		Employee emp = employeeDB.get(id);
		bankAccountDB.delete(emp.getaddress());
		payrollDB.delete(emp.getType(), emp.getID());
		employeeDB.delete(id);	
	}
	
	public void changeEmployee(int id, EmployeeType type,String money) {
		Employee emp = employeeDB.get(id);
		payrollDB.delete(emp.getType(), emp.getID());
		emp.setType(type);
		payrollDB.addTransaction(createTransaction(emp, money), type);
	}
	
	public void changeAddressTransaction(int empid,String address) {
		Employee emp = employeeDB.get(empid);
		bankAccountDB.delete(emp.getaddress());
		emp.setaddress(address);
		emp.setPaymentMethod(PaymentFilter.createby(address));
		try {
			if (bankAccountDB.find(address)) {
				throw new Exception("Address already taken");
			}
			else
				bankAccountDB.add(Util.createby(emp));

		}catch(Exception e) {
			throw new IllegalArgumentException("Address already taken");
		}
	}
	
	private boolean istimeToPay(int time, int time2pay) {
		return time % time2pay == 0;
	}
	
}
