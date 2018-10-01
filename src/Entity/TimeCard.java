package Entity;

import java.time.LocalTime;

public class TimeCard {
	
	private LocalTime lcstart;
	private LocalTime lcend;
	
	public TimeCard(LocalTime lcstart,LocalTime lcend) {
		this.lcend = lcend;
		this.lcstart = lcstart;
	}
	
	public int gethr() {
		return lcend.getHour() - lcstart.getHour();
	}
	
}
