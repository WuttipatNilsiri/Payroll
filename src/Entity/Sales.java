package Entity;

import java.util.ArrayList;
import java.util.List;

public class Sales {
	
	private List<String> list = new ArrayList<String>();
	
	public void add(String... args) {
		for (String s : args) {
			list.add(s);
		}
	}

	public int getAmoutOfItem() {
		// TODO Auto-generated method stub
		return list.size();
	}

}
