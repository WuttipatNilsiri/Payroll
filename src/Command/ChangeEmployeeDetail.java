package Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Lib.Util;

public class ChangeEmployeeDetail implements Command {

	private Map<String, String> mapInput = new HashMap<String,String>();
	private List<Command> cmdList = new ArrayList<Command>();

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return Util.isValueValid(mapInput , "id");
	}

	@Override
	public void input(String input) {
		
		
		for (String x : input.split(" ")) {
			String[] arg = x.split("=");
			mapInput.put(arg[0], arg[1]);
		}
		
		
		if (Util.isValueValid(mapInput , "address")) {
			Command c = new ChageAdressTransaction();
			c.input(String.format("id=%d address=%s", Integer.parseInt(mapInput.get("id")) , mapInput.get("address") ));
			cmdList.add(c);
		}
		if (Util.isValueValid(mapInput , "type") && Util.isValueValid(mapInput , "money")) {
			Command c = new ChangeEmployeeType();
			c.input(String.format("id=%s type=%s money=%s", Integer.parseInt(mapInput.get("id")) , mapInput.get("type") , mapInput.get("money") ));
			cmdList.add(c);
		}
//		System.out.println(cmdList.size());
	}

	@Override
	public void exec() {
		for(Command c : cmdList) {
			c.exec();
		}
		cmdList.clear();
		mapInput.clear();
	}
	
}
