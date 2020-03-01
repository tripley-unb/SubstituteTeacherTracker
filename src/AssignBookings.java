import java.util.ArrayList;
import java.util.Random;

public class AssignBookings {
	private ArrayList<Assignment> assignments;
 	private ArrayList<Absence> absences;
	private ArrayList<Substitute> substitutes;
	private ArrayList<Integer> subindex;

	
	private Random random;

	public AssignBookings(ArrayList<Absence> a, ArrayList<Substitute> s) {
		absences = a;
		substitutes = s;
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
		int counter = 0;
		
		Substitute substitute = new Substitute();
		Absence absence = new Absence();
		Absence booking = new Absence();
		boolean conflict = false;

		while (absences.size()!=0) {//cycle through absences at random

			//choose one of the absences at random
			randindexA = random.nextInt(absences.size());
			absence = absences.get(randindexA);
			for (int i=0; i<substitutes.size();i++) {//re-initialize subindex list
				subindex.add(i);
			}
			System.out.println("abs up: "+absence);
			System.out.println(subindex.size());
			
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
					
					System.out.println(counter);
					counter = counter + 1;
					
					//add new assignment to list
					assignments.add(new Assignment(substitute.getName(),absence.getTeacher().getName(),absence.getTime(),absence.getDay(),absence.getLocation()));
					System.out.println(new Assignment(substitute.getName(),absence.getTeacher().getName(),absence.getTime(),absence.getDay(),absence.getLocation()));
					absences.remove(randindexA);//remove absence from absence list
					
					break cyclesubs;//return to cycle absences now the assignment has been made
				}
				
				subindex.remove(randindexS);//remove index representing substitute from list if they can't fill absence
			}
		}
	}
	
	public ArrayList<Assignment> getAssignments(){
		return assignments;
	}
}

