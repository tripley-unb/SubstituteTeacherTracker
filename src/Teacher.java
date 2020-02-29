import java.util.ArrayList;

public class Teacher {
	private String name;
	private ArrayList<String> teachables;
	
	public Teacher(String name, ArrayList<String> teachables) {
		this.name = name;
		this.teachables = teachables;
	}
	
	public Teacher(ArrayList<String> teachables, String name) {
		this.name = name;
		this.teachables = teachables;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<String> getTechables() {
		return teachables;
	}
	
}
