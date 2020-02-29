import java.util.ArrayList;

public class TeacherList {
	private ArrayList<Absence> absences;
	
	public TeacherList() {
		absences = new ArrayList<Absence>();
	}
	
	public void addTeacher(Absence a) {
		absences.add(a);
	}
}
