import java.util.ArrayList;

public class AbsenceList {
	private ArrayList<Absence> absences;
	
	public AbsenceList() {
		absences = new ArrayList<Absence>();
	}
	
	public void addTeacher(Absence a) {
		absences.add(a);
	}
}
