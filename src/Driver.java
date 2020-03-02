import java.io.*;
import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
			AbsenceList abslist = InputCSV.ReadAbsenceCSV("absences.csv");
			SubList sublist = InputCSV.ReadSubCSV("substitutes.csv");
			System.out.println(abslist);
			System.out.println(sublist + "\n");
			AssignBookings assignB = new AssignBookings(abslist.getList(),sublist.getList());
			assignB.assign();
			ArrayList<Assignment> list = new ArrayList<Assignment>();
			list = assignB.getAssignments();
			System.out.println(list);
			
			
//			Assignment a = new Assignment("A","b","c","d","e");
//			Assignment b = new Assignment("fd","sdf","csd","sd","ef");
//			ArrayList<Assignment> list = new ArrayList<Assignment>();
//			list.add(a);
//			list.add(b);
//			System.out.println(list);
			
			OutputCSV.createCSV(list);
	}

}
