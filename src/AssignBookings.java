import java.util.ArrayList;
import java.util.Random;

public class AssignBookings {
	private ArrayList<Assignment> assignments;
 	private ArrayList<Absence> absences;
	private ArrayList<Substitute> substitutes;
	private ArrayList<Integer> absindex;
	private ArrayList<Integer> subindex;
	private boolean teachables;
	
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
	
	private ArrayList<Integer> subIndexList(){
		if (teachables == true) {
			
		}
		for (int i=0; i<substitutes.size();i++) {				
			subindex.add(i);
		}
		return subindex;
	}
	
	private boolean checkConflict(Substitute substitute, Absence absence) {
		Absence booking = new Absence();
		boolean conflict = false;
		if (substitute.getBooking().size()!=0) {//if the sub has bookings
			for (int j=0; j<substitute.getBooking().size(); j++){//cycle through sub's bookings
				booking = substitute.getBooking().get(j);
				if (booking.getDay().equals(absence.getDay()) && (booking.getTime().equals(absence.getTime()))) {//if sub is booked during absence
					conflict = true;
				}
			}
		}
		return conflict;
	}
	
	private void noSubforAbsence(Absence absence, int randindexA) {
		if (subindex.size() == 0) {//no subs to fill absence
			System.out.println("WARNING! no subs to fill absence: "+absence);
			assignments.add(new Assignment("NONE AVAILABLE",absence.getTeacher().getName(),absence.getTime(),absence.getDay(),absence.getLocation()));
			absindex.remove(randindexA);//remove absence from absence list
		}
	}
	
	private int tallyTeachables(boolean teachables, Absence absence, Substitute substitute) {
		int match = 0;
		if (teachables == true) {			
			for(int j=0; j<absence.getTeachables().size();j++) {//cycle through absence's teachables
				for(int k=0; k<substitute.getTeachables().size(); k++) {//cycle through substitute's teachables
					if(absence.getTeachables().get(j).equals(substitute.getTeachables().get(k))) {
						match++;
					}
				}

			}
			
		}
//		System.out.println(absence.getTeachables()+" "+absence.getTeacher().getName()+" "+substitute.getName()+substitute.getTeachables()+" match:"+match);
		return match;
	}
	
	private int teachablesBestMatch(boolean teachables, Absence absence) {
		//function returns index of substitutes
		//returns -1 if there are no matches
		int matches = 0;
		int mostmatches = 0;
		int bestmatch = -1;
		
		for(int i=0; i<subindex.size(); i++) {//cycle through shrinking list of substitutes
			matches = tallyTeachables(teachables,absence, substitutes.get(subindex.get(i)));//check amount of matches of sub
			if(matches>mostmatches) {
				mostmatches = matches;
				bestmatch = i;//return index value from subindex that represents the sub
			}
		}
		return bestmatch;
	}
	
	private int isBlacklisted(Absence a, Substitute s){
	    ArrayList<String> blacklist = new ArrayList<String>();
	    s.getBlacklist();
	   
	    for(String string : blacklist){
	        if(a.getLocation().equals(string)){
	            return 0;
	        }
	    }
	    return 1;
	}


	public void assign() {
		
		int indexS;
		int indexA;
		
		Substitute substitute = new Substitute();
		Absence absence = new Absence();
		ArrayList<Integer> subs_teachables_match = new ArrayList<Integer>();
		
		boolean conflict = false;
		boolean teachables = false;
//		boolean regular = false;
//		...

		while (absindex.size()!=0) {//cycle through absences at random
			
			//reinitialize variables
			teachables = false;
			indexA = -1;
			int i = 0;
			
			//select absence
			while(indexA == -1 && i<absindex.size()) {
				if(absences.get(absindex.get(i)).getTeachables().size()>0) {//if absence has teachables
					indexA = i;
				}
				i++;
			}
			if(indexA == -1){//no absences with teachables
				//choose one of the absences at random
				indexA = random.nextInt(absindex.size());//choose random index for index list
			}
			absence = absences.get(absindex.get(indexA));
			
			//check for special conditions
			if(absence.getTeachables().size()>0) {
				teachables = true;//absence has teachables
			}
			
			//re-initialize subindex list
			subIndexList();
			
			cyclesubs: while (subindex.size()!=0) {//cycle through substitutes at random
				
				conflict = false;//reset conflict flag
				
				if(teachables == true && teachablesBestMatch(teachables, absence) != -1) {
					//absence has teachables and they match one of the subs
					//find bestmatch
					indexS = teachablesBestMatch(teachables, absence);
//					System.out.println(absindex.get(indexA)+":"+subindex.get(indexS));
				}
				else {
					//choose one of the substitutes at random
					indexS = random.nextInt(subindex.size());//choose random index for index list
				}
				substitute = substitutes.get(subindex.get(indexS));
				
				conflict = checkConflict(substitute, absence);
				
				if (conflict == false) {//if there aren't any conflicts
					
					substitute.addBooking(absence);//add booking to subs list
					
					//add new assignment to list
					assignments.add(new Assignment(substitute.getName(),absence.getTeacher().getName(),absence.getTime(),absence.getDay(),absence.getLocation()));
					absindex.remove(indexA);//remove absence from absence list
					break cyclesubs;//return to cycle absences now the assignment has been made
				}
				subindex.remove(indexS);//remove index representing substitute from list if they can't fill absence
			}
			
			noSubforAbsence(absence, indexA);
		}
	}
	
	public ArrayList<Assignment> getAssignments(){
		return assignments;
	}
}

