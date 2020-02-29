import java.util.ArrayList;

public class Substitute {
	private String name;
	private ArrayList<String> teachables;
	private ArrayList<String> blacklist;
	private ArrayList<String> bookings;
	
	public Substitute(String name, ArrayList<String> teachables, ArrayList<String> blacklist) {
		this.name = name;
		this.teachables = teachables;
		this.blacklist = blacklist;
		bookings = new ArrayList<String>();
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<String> getTeachables() {
		return teachables;
	}
	
	public ArrayList<String> getBlacklist() {
		return blacklist;
	}
	
	public ArrayList<String> getBooking(){
		return bookings;
	}
	
	public void addBooking(String booking) {
		bookings.add(booking);
	}
	
	
}
