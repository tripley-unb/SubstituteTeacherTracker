import java.util.ArrayList;
import java.util.Random;

public class AssignBookings {
	private ArrayList<Assignment> assignments;
	private ArrayList<Absence> absences;
	private ArrayList<Substitute> substitutes;
	private Random random;

	public AssignBookings(ArrayList<Absence> a, ArrayList<Substitute> s) {
		absences = a;
		substitutes = s;
		assignments = new ArrayList<Assignment>();
		random = new Random();
	}
	
	public void assign() {
		
		int randindex;
		Absence absence = new Absence();
		Absence booking = new Absence();
		boolean conflict = false;

		while (absences.size()!=0) {//cycle through absences at random

			//choose one of the absences at random
			randindex = random.nextInt(absences.size());
			absence = absences.get(randindex);
			
			cyclesubs: for (int i=0; i<substitutes.size(); i++) {//cycle through list of subs while absence is unassigned
				conflict = false;//reset conflict flag
				
				if (substitutes.get(i).getBooking().size()!=0) {//if the sub has bookings

					for (int j=0; j<substitutes.get(i).getBooking().size(); j++){//cycle through sub's bookings
						
						booking = substitutes.get(i).getBooking().get(j);
						
						if (booking.getDay().equals(absence.getDay()) && (booking.getTime().equals(absence.getTime()))) {//if sub is booked during absence
							conflict = true;
						}
					}
				}
				
				if (conflict == false) {//if there aren't any conflicts
					substitutes.get(i).addBooking(absence);//add booking to subs list
					
					//add new assignment to list
					assignments.add(new Assignment(substitutes.get(i).getName(),absence.getTeacher().getName(),absence.getTime(),absence.getDay(),absence.getLocation()));
					
					absences.remove(randindex);//remove absence from absence list
					break cyclesubs;//exit for loop now that assignment has been made
				}
			}
		}
	}
	
	public ArrayList<Assignment> getAssignments(){
		return assignments;
	}
}

