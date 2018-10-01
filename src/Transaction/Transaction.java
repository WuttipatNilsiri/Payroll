package Transaction;

public interface Transaction {
	
	public void Execute();
	
	public int getID();
	
	public boolean isTime2Pay(int time);
}
