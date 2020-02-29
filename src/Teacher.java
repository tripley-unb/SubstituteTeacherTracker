import java.util.ArrayList;

public class Teacher {
	private String name;
	private ArrayList<String> teachables;
	
	public Teacher() {
		this("none", new ArrayList<String>());
	}
	
	public Teacher(String name, ArrayList<String> teachables) {
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
