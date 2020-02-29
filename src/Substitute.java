import java.util.ArrayList;

public class Substitute {
	private String name;
	private ArrayList<Absence> bookings;
	
	public Substitute(String name) {
		this.name = name;
		bookings = new ArrayList<Absence>();
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Absence> getBooking(){
		return bookings;
	}
	
	public void addBooking(Absence booking) {
		bookings.add(booking);
	}
	
}
