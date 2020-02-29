import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class Driver {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
<<<<<<< HEAD
			InputCSV.ReadTeacherCSV("teachers.csv");
=======
			Assignment a = new Assignment("A","b","c","d","e");
			Assignment b = new Assignment("fd","sdf","csd","sd","ef");
			ArrayList<Assignment> list = new ArrayList<Assignment>();
			list.add(a);
			list.add(b);
			OutputCSV.createCSV(list);
>>>>>>> 4fb9aab542b1fe4a68786657edf06827ca0ba7af
	}

}
