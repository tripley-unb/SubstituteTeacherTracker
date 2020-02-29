
public class Absence {
	private String day;
	private String time;
	private String location;
	
	public Absence(String day, String time, String location) {
		this.day = day;
		this.time = time;
		this.location = location;
	}
	
	public String getDay() {
		return day;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getLocation() {
		return location;
	}
}
