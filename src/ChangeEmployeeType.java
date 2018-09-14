import java.util.HashMap;
import java.util.Map;

public class ChangeEmployeeType implements Command {

	Map<String,String> mapInput = new HashMap<String,String>();
	
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
	}

	
	public void exec() {
		int id = Integer.parseInt(mapInput.get("id"));
		EmployeeType type = Util.char2type(mapInput.get("type"));
		String money = mapInput.get("money");
		Payroll.changeEmployee(id, type, money);
	}
	
}
