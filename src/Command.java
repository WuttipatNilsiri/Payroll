
public interface Command {
	

	public abstract boolean isValid();
	public abstract void input(String input);
	public abstract void exec();
}
