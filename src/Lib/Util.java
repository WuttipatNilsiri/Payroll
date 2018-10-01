package Lib;
import java.util.Map;

import Entity.Employee;
import Entity.EmployeeType;

import Address.*;


public class Util {
	
	public static boolean isValueValid(Map<String,String> a,String key) {
		
		if (!a.containsKey(key)) {
			return false;
		}
		
		if (a.get(key) != null) {
			return true;
		}
		
		return false;
		
	}
	
	public static EmployeeType char2type(String in) {
		if (in.equals("H")) {
			return EmployeeType.Hourly;
		}
		
		if (in.equals("C")) {
			return EmployeeType.Commissioned;
		}
		
		if (in.equals("S")) {
			return EmployeeType.Salaried;
		}
		
		return EmployeeType.Unknown;
	}
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	public static Address createby(Employee e) {
		
		if (e.getaddress().contains("@")) {
			return new MailAccount(e.getaddress(),e.getName());
		}
		if (Util.isNumeric(e.getaddress())) {
			return new BankAccount(e.getaddress(),e.getName());
		}
		
		return null;
		
		
	}
}
