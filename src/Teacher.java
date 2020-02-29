import java.util.ArrayList;

public class Teacher {
	private String name;
	private ArrayList<Absence> absences;
	
	public Teacher(String name) {
		this.name = name;
		absences = new ArrayList<Absence>();
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Absence> getAbsences(){
		return absences;
	}
	
	public void addAbsence(Absence A) {
		absences.add(A);
	}
}
