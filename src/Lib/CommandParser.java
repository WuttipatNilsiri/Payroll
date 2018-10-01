package Lib;
import Command.AddEmployeeTransaction;
import Command.ChageAdressTransaction;
import Command.ChangeEmployeeType;
import Command.Command;
import Command.DeleteEmployee;

public class CommandParser {

	public static Command create(String arg) {
		String[ ] spedArg = arg.split(":");
		if (spedArg[0].equals("addEmp")) {
			Command cmd = new AddEmployeeTransaction();
			cmd.input(spedArg[1]);
			return cmd;
		}
		else if (spedArg[0].equals("chgAdd")) {
			Command cmd = new ChageAdressTransaction();
			cmd.input(spedArg[1]);
			return cmd;
		}
		else if (spedArg[0].equals("dltEmp")) {
			Command cmd = new DeleteEmployee();
			cmd.input(spedArg[1]);
			return cmd;
		}
		else if (spedArg[0].equals("chgEmp")) {
			Command cmd = new ChangeEmployeeType();
			cmd.input(spedArg[1]);
			return cmd;
		}
		else
			throw new IllegalArgumentException("Unknown Cmd");
	}
	
}
