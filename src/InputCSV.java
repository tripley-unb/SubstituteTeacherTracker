import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InputCSV {
	
	private static final String csvPath = "subData/";
	
	public static TeacherList ReadTeacherCSV(String csvName) throws IOException {
		TeacherList teacherlist = new TeacherList();
		
		try {
	            Reader reader = Files.newBufferedReader(Paths.get(csvPath + csvName));
	            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
	    
				for (CSVRecord csvRecord : csvParser) {
					String name = csvRecord.get(0);
					String location = csvRecord.get(1);
					String teachables = csvRecord.get(2);
				
				}
				
		} catch (IOException io) {
			System.out.println("Error reading CSV file");
			io.printStackTrace();
		}
		
		return teacherlist;
	}
	
	public static SubList ReadSubCSV(String csvName) throws IOException {
		SubList sublist = new SubList();
		
		try (
	            Reader reader = Files.newBufferedReader(Paths.get(csvPath + csvName));
	            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
	    ) {
			for (CSVRecord csvRecord : csvParser) {

				
				
				
			}
		}
		
		return sublist;
	}
	
	
	
}
