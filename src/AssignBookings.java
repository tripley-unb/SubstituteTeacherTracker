import java.util.ArrayList;
import java.util.Random;

public class AssignBookings {
	private ArrayList<Assignment> assignments;
 	private ArrayList<Absence> absences;
	private ArrayList<Assignment> assignmentsOriginal;
 	private ArrayList<Absence> absencesOriginal;
	private ArrayList<Substitute> substitutes;
	private Random random;

	public AssignBookings(ArrayList<Absence> a, ArrayList<Substitute> s) {
		absences = a;
		substitutes = s;
		assignments = new ArrayList<Assignment>();
		random = new Random();
	}
	
	public void assign() {
		
		int randindexS;
		int randindexA;
		
		Substitute substitute = new Substitute();
		Absence absence = new Absence();
		Absence booking = new Absence();
		boolean conflict = false;

		while (absences.size()!=0) {//cycle through absences at random

			//choose one of the absences at random
			randindexA = random.nextInt(absences.size());
			absence = absences.get(randindexA);
			
			cyclesubs: while (substitutes.size()!=0) {//cycle through substitutes at random
				conflict = false;//reset conflict flag
				
				//choose on of the substitutes at random
				randindexS = random.nextInt(substitutes.size());
				substitute = substitutes.get(randindexS);				
				
				if (substitutes.get(randindexS).getBooking().size()!=0) {//if the sub has bookings

					for (int j=0; j<substitute.getBooking().size(); j++){//cycle through sub's bookings
						
						booking = substitute.getBooking().get(j);
						
						if (booking.getDay().equals(absence.getDay()) && (booking.getTime().equals(absence.getTime()))) {//if sub is booked during absence
							conflict = true;
						}
					}
				}
				
				if (conflict == false) {//if there aren't any conflicts
					substitute.addBooking(absence);//add booking to subs list
					
					//add new assignment to list
					assignments.add(new Assignment(substitute.getName(),absence.getTeacher().getName(),absence.getTime(),absence.getDay(),absence.getLocation()));
					
					absences.remove(randindexA);//remove absence from absence list
					break cyclesubs;//exit for loop now that assignment has been made
				}
				
				substitutes.remove(randindexS);//remove substitute from substitute list
			}
		}
	}
	
	public ArrayList<Assignment> getAssignments(){
		return assignments;
	}
}

