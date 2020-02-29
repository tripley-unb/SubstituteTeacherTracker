import java.util.ArrayList;

public class Substitute {
	private String name;
	private ArrayList<String> bookings;
	
	public Substitute(String name) {
		this.name = name;
		bookings = new ArrayList<String>();
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<String> getBooking(){
		return bookings;
	}
	
	public void addBooking(String booking) {
		bookings.add(booking);
	}
	
}
