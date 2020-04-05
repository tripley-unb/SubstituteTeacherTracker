import java.util.ArrayList;

public class Substitute {
	private String name;
	private ArrayList<String> teachables;
	private ArrayList<String> blacklist;
	private ArrayList<Absence> bookings;
	private ArrayList<String> onCalls;
	
	public Substitute(String name) {
		this("none", new ArrayList<String>(), new ArrayList<String>());
		this.name = name;
	}

	public Substitute() {
		this("none", new ArrayList<String>(), new ArrayList<String>());
	}
	public Substitute(String name, ArrayList<String> teachables, ArrayList<String> blacklist) {
		this.name = name;
		this.teachables = teachables;
		this.blacklist = blacklist;
		bookings = new ArrayList<Absence>();
		onCalls = new ArrayList<String>();
	}

	public Substitute(String name, ArrayList<String> teachables, ArrayList<String> blacklist, ArrayList<String> onCalls) {
		this.name = name;
		this.teachables = teachables;
		this.blacklist = blacklist;
		bookings = new ArrayList<Absence>();
		this.onCalls = onCalls;
	}

	public void addOnCall(String location) {
		onCalls.add(location);
	}

	public ArrayList<String> getOnCalls() {
		return onCalls;
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
