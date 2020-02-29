import java.util.ArrayList;
import java.util.Random;

public class AssignBookings {
	private ArrayList<Assignment> assignments;
	private ArrayList<Absence> absences;
	private ArrayList<Substitute> substitutes;
	
	Random random = new Random();

	public AssignBookings(ArrayList<Absence> a, ArrayList<Substitute> s) {
		absences = a;
		substitutes = s;
	}
	
	public void assign() {
		int randindex;
		int amountbooked;
		Absence absence = new Absence();
		Absence booking = new Absence();
		
		//choose one of the absences at random
		randindex = random.nextInt(absences.size());
		absence = absences.get(randindex);
		
		for (int i=0; i<substitutes.size(); i++) { //cycle through list of subs
			for (int j=0; j<substitutes.get(i).getBooking().size(); j++){ //cycle through sub's bookings
				booking = substitutes.get(i).getBooking().get(j);
				if (!(booking.getDay() == absence.getDay() && booking.getTime() == absence.getTime())) {//if sub is not booked during absence
					
				}
			}
		}
		
		
	}
	
	public ArrayList<Assignment> getAssignments(){
		return assignments;
	}
}

