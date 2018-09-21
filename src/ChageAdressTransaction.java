import java.util.HashMap;
import java.util.Map;

public class ChageAdressTransaction implements Command {

	private Map<String,String> mapInput = new HashMap<String,String>();
	
	private Payroll sys = Payroll.getSystem();
	
	public boolean isValid() {
		// TODO Auto-generated method stub
		return 
				Util.isValueValid(mapInput, "id") &&
				
				Util.isValueValid(mapInput, "address");
				
	}
	
	
	/**
	 * id=<id> address=<address>
	 */
	public void input(String input) {
		for (String x : input.split(" ")) {
			String[] arg = x.split("=");
			mapInput.put(arg[0], arg[1]);
		}
	}
	
	

	
	public void exec() {
		if (!isValid()) {
			throw new IllegalArgumentException("Some Arg are missing");
		}
		int empid = Integer.parseInt(mapInput.get("id"));	
		String bankid = mapInput.get("address");
		
		sys.changeAddressTransaction(empid, bankid );
		
		mapInput.clear();
	}
	
	
}
