import java.util.ArrayList;
import java.util.Random;

public class AssignBookings {
	private ArrayList<Assignment> assignments;
 	private ArrayList<Absence> absences;
	private ArrayList<Substitute> substitutes;
	private ArrayList<Integer> absindex;
	private ArrayList<Integer> subindex;
	
	private Random random;

	public AssignBookings(ArrayList<Absence> a, ArrayList<Substitute> s) {
		absences = a;
		substitutes = s;
		
		absindex = new ArrayList<Integer>();//initialize list that correlates to absence list index
		for (int i=0; i<absences.size();i++) {
			absindex.add(i);
		}
		
		subindex = new ArrayList<Integer>();//initialize list that correlates to sub list index
		for (int i=0; i<substitutes.size();i++) {
			subindex.add(i);
		}
		
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

		while (absindex.size()!=0) {//cycle through absences at random

			//choose one of the absences at random
			randindexA = random.nextInt(absindex.size());
			absence = absences.get(absindex.get(randindexA));
			
			for (int i=0; i<substitutes.size();i++) {//re-initialize subindex list
				subindex.add(i);
			}
			
			cyclesubs: while (subindex.size()!=0) {//cycle through substitutes at random
				
				conflict = false;//reset conflict flag
				
				//choose on of the substitutes at random
				randindexS = random.nextInt(subindex.size());//choose random index for index list
				substitute = substitutes.get(subindex.get(randindexS));				
				
				if (substitute.getBooking().size()!=0) {//if the sub has bookings
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
					absindex.remove(randindexA);//remove absence from absence list
					break cyclesubs;//return to cycle absences now the assignment has been made
				}
				
				subindex.remove(randindexS);//remove index representing substitute from list if they can't fill absence
			}
			
			if (subindex.size() == 0) {//no subs to fill absence
				System.out.println("WARNING! no subs to fill absence: "+absence);
				assignments.add(new Assignment("NONE AVAILABLE",absence.getTeacher().getName(),absence.getTime(),absence.getDay(),absence.getLocation()));
				absindex.remove(randindexA);//remove absence from absence list
			}
		}
	}
	
	public ArrayList<Assignment> getAssignments(){
		return assignments;
	}
}

