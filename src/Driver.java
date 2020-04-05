import java.io.*;
import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) throws IOException{
		AbsenceList abslist = InputCSV.ReadAbsenceCSV("absences.csv");
		SubList sublist = InputCSV.ReadSubCSV("substitutes.csv");
		for(int i=0; i<abslist.getList().size(); i++) {
			System.out.println(abslist.getList().get(i).getTeachables());
		}
		for(int i=0; i<sublist.getList().size(); i++) {
			System.out.println(sublist.getList().get(i).getTeachables());
		}
		System.out.println(abslist);
		System.out.println(sublist + "\n");
		AssignBookings assignB = new AssignBookings(abslist.getList(),sublist.getList());
		assignB.assign();
		ArrayList<Assignment> list = new ArrayList<Assignment>();
		list = assignB.getAssignments();
		System.out.println(list);
		
		OutputCSV.createCSV(list);
	}

}
