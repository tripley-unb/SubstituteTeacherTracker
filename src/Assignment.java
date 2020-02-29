
public class Assignment {
	private String substitute;
	private String teacher;
	private String time;
	private String date;
	private String location;
	
	public Assignment(String substitute, String teacher, String time, String date, String location) {
		this.substitute = substitute;
		this.teacher = teacher;
		this.time = time;
		this.date = date;
		this.location = location;
	}
	public String getSubName() {
		return substitute;
	}
	
	public String getTeacherName() {
		return teacher;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getLocation() {
		return location;
	}
}
