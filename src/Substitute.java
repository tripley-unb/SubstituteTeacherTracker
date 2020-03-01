import java.util.ArrayList;

public class Substitute {
	private String name;
	private ArrayList<String> teachables;
	private ArrayList<String> blacklist;
	private ArrayList<Absence> bookings;
	
	public Substitute() {
		this("none", new ArrayList<String>(), new ArrayList<String>());
	}
	public Substitute(String name, ArrayList<String> teachables, ArrayList<String> blacklist) {
		this.name = name;
		this.teachables = teachables;
		this.blacklist = blacklist;
		bookings = new ArrayList<Absence>();
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
	
	public ArrayList<Absence> getBooking(){
		return bookings;
	}
	
	public void addBooking(Absence booking) {
		bookings.add(booking);
	}
	
	public String toString() {
		return "sub: " + getName();
	}
}
