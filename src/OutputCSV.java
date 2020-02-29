import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class OutputCSV {
	private static String assignments = "./assignments.csv";
	
	public static void createCSV() throws IOException {
		try {
	        BufferedWriter writer = Files.newBufferedWriter(Paths.get(assignments));
	
	        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Teacher", "Substitute", "Time", "Date", "Location"));
		
	            csvPrinter.printRecord("1", "Sundar Pichai", "CEO", "Google");
	            csvPrinter.printRecord("2", "Satya Nadella", "CEO", "Microsoft");
	            csvPrinter.printRecord("3", "Tim cook", "CEO", "Apple");
	
	            csvPrinter.printRecord(Arrays.asList("4", "Mark Zuckerberg", "CEO", "Facebook"));
	
	            csvPrinter.flush();
		
		} catch (IOException io) {
			System.out.println("Error writing CSV file");
			io.printStackTrace();
		}
	}
}
