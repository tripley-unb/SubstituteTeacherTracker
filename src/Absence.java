import java.util.ArrayList;

public class Absence {
	private String day;
	private String time;
	private String location;
	private Teacher teacher;
	private ArrayList<String> teachables;
	
	public Absence() {
		this("none","none","none", new Teacher(),new ArrayList<String>());
	}
	
	public Absence(String day, String time, String location, Teacher teacher, ArrayList<String> teachables) {
		this.day = day;
		this.time = time;
		this.location = location;
		this.teacher = teacher;
		this.teachables = teachables;
	}
	
	public String getDay() {
		return day;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getLocation() {
		return location;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	public ArrayList<String> getTeachables(){
		return teachables;
	}
	
	public String toString() {
		return "teacher: " + getTeacher().getName() + " day: " + getDay() + " time: " + getTime() + " location: " + getLocation();
	}
}
