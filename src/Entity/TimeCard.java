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
	
	public static TimeCard create(String start,String end) {
		String[] s = start.split(":");
		String[] e = end.split(":");
		return new TimeCard(LocalTime.of(Integer.parseInt(s[0]),Integer.parseInt(s[1])),LocalTime.of(Integer.parseInt(e[0]),Integer.parseInt(e[1])));
	}
	
}
