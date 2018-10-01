package Entity;
import java.util.ArrayList;
import java.util.List;

import Lib.PaymentFilter;
import PaymentMethod.Payment;
import PaymentMethod.PaymentMethod;
import Transaction.SalariedEmployeeTransaction;

public class Employee {
	
	private int id;
	
	private String name;
	private String address;
	
	private List<Sales> saleslist = new ArrayList<Sales>();
	
	private EmployeeType type = EmployeeType.Unknown;
	
	private PaymentMethod paymentMethod; 
	
	
	private List<TimeCard> list = new ArrayList<TimeCard>();
	public Employee(int id, String name, String address){
		this.id = id;
		this.name = name;
		this.address = address;
		paymentMethod = PaymentFilter.createby(address);
	}
	
	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
//	public String getAddress() {
//		return address;
//	}
	
	public String getaddress() {
		return address;
	}
	
	public void setType(EmployeeType type) {
		this.type = type;
	}
	
	public void setaddress(String id) {
		address = id;
	}
	
	public EmployeeType getType() {
		return type;
	}
	
	public void addsales(Sales s) {
		saleslist.add(s);
	}
	
	public void addTimeCard(TimeCard tc) {
		list.add(tc);
	}
	
	public int getHours() {
		int sum = 0;
		for (TimeCard tc : list) {
			sum = sum + tc.gethr();
		}
		return sum;
	}
	
	public int get_Num_Sell_Item() {
		int sum = 0;
		for (Sales s : saleslist) {
			sum = sum + s.getAmoutOfItem();
		}
		return sum;
	}
	
	public void resetSales() {
		saleslist.clear();
	}
	
	public PaymentMethod getPaymentMethod() {
		return  paymentMethod;
	}
	
	public void setPaymentMethod(PaymentMethod pm) {
		paymentMethod = pm;
	}
	
	
	
	
	
	
}
