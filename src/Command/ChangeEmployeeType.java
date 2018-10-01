package Command;
import java.util.HashMap;
import java.util.Map;

import Entity.EmployeeType;
import Lib.Util;
import System.Payroll;

public class ChangeEmployeeType implements Command {

	private Map<String,String> mapInput = new HashMap<String,String>();
	
	private Payroll sys = Payroll.getSystem();
	
	public boolean isValid() {
		// TODO Auto-generated method stub
		return 
				Util.isValueValid(mapInput, "id") &&
				
//				Util.isValueValid(mapInput, "bankAccount") &&
				Util.isValueValid(mapInput, "type") &&
				Util.isValueValid(mapInput, "money");
	}

	
	public void input(String input) {
		for (String x : input.split(" ")) {
			String[] arg = x.split("=");
			mapInput.put(arg[0], arg[1]);
		}
		if (!isValid()) {
			throw new IllegalArgumentException("Some Arg are missing");
		}
	}
	
	

	
	public void exec() {
		
		int id = Integer.parseInt(mapInput.get("id"));
		EmployeeType type = Util.char2type(mapInput.get("type"));
		String money = mapInput.get("money");
		sys.changeEmployee(id, type, money);
		mapInput.clear();
	}
	
}
