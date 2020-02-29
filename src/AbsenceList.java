import java.util.ArrayList;

public class AbsenceList {
	private ArrayList<Absence> absences;
	
	public AbsenceList() {
		absences = new ArrayList<Absence>();
	}
	
	public void addAbsence(Absence a) {
		absences.add(a);//need to add only absences that aren't already there
	}
}
