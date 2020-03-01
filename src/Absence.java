
public class Absence {
	private String day;
	private String time;
	private String location;
	private Teacher teacher;
	
	public Absence() {
		this("none","none","none", new Teacher());
	}
	
	public Absence(String day, String time, String location, Teacher teacher) {
		this.day = day;
		this.time = time;
		this.location = location;
		this.teacher = teacher;
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
	
	public String toString() {
		return "teacher: " + getTeacher().getName() + " day: " + getDay() + " time: " + getTime() + " location: " + getLocation();
	}
}
