import java.util.ArrayList;

public class TeacherList {
	private ArrayList<Teacher> teachers;
	
	public TeacherList() {
		teachers = new ArrayList<Teacher>();
	}
	
	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
	}
}
