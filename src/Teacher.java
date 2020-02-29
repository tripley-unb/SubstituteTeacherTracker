import java.util.ArrayList;

public class Teacher {
	private String name;
	private String location;
	private ArrayList<String> teachables;
	private ArrayList<Absence> absences;
	
	public Teacher(String name, String location, ArrayList<String> teachables) {
		this.name = name;
		this.location = location;
		this.teachables = teachables;
		absences = new ArrayList<Absence>();
	}
	
	public String getName() {
		return name;
	}
	
	public String getLocation() {
		return location;
	}
	
	public ArrayList<String> getTechables() {
		return teachables;
	}
	
	public ArrayList<Absence> getAbsences(){
		return absences;
	}
	
	public void addAbsence(Absence A) {
		absences.add(A);
	}
}
