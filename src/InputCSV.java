import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InputCSV {
	
	private static final String csvPath = "../subData/";
	private TeacherList teachers;
	private SubList subs;
	
	public static void ReadCSV(String csvName) throws IOException {
		try (
	            Reader reader = Files.newBufferedReader(Paths.get(csvPath + csvName));
	            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
	    ) {
			for (CSVRecord csvRecord : csvParser) {
				
			}
		}
	}
	
	
	
}
