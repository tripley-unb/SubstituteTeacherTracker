import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class OutputCSV {
	private static final String assignments = "./assignments.csv";
	
	public static void createCSV(ArrayList<Assignment> List) throws IOException {
		try {
	        BufferedWriter writer = Files.newBufferedWriter(Paths.get(assignments));
	
	        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Teacher", "Substitute", "Time", "Date", "Location"));
	        	for (Assignment a: List) {
	        		csvPrinter.printRecord(a.getTeacherName(),a.getSubName(),a.getTime(),a.getDate(),a.getLocation());
	        	}

	            csvPrinter.flush();
		
		} catch (IOException io) {
			System.out.println("Error writing CSV file");
			io.printStackTrace();
		}
	}
}
