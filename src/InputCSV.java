import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InputCSV {
	
	private static final String csvPath = "subData/";
	
	public static AbsenceList ReadAbsenceCSV(String csvName) throws IOException {
		AbsenceList teacherlist = new AbsenceList();
		
		try {
	            Reader reader = Files.newBufferedReader(Paths.get(csvPath + csvName));
	            CSVFormat format = CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader();
	            CSVParser csvParser = new CSVParser(reader, format);
	    
				for (CSVRecord csvRecord : csvParser) {
					String date = csvRecord.get("date");
					String period = csvRecord.get("period");
					String teacher = csvRecord.get("teacher");
					String location = csvRecord.get("location");
					String teachables = csvRecord.get("teachables");
					System.out.println(teachables);
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
