import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class InputCSV {
	
	private static final String csvPath = "subData/";
	
	public static AbsenceList ReadAbsenceCSV(String csvName) throws IOException {
		AbsenceList absenceList = new AbsenceList();
		
		try {
	            Reader reader = Files.newBufferedReader(Paths.get(csvPath + csvName));
	            CSVParser csvParser = new CSVParser(reader, CSVFormat.EXCEL.withFirstRecordAsHeader());
	    
				for (CSVRecord csvRecord : csvParser) {
					String date = csvRecord.get("date");
					String period = csvRecord.get("period");
					String teacherName = csvRecord.get("teacher");
					String location = csvRecord.get("location");
					String teachables = csvRecord.get("teachables");
					
					Teacher teacher = new Teacher(teacherName, InputCSV.parseTeachables(teachables));
					Absence absence = new Absence(date, period, location, teacher);
					absenceList.addAbsence(absence);
				}
				
		} catch (IOException io) {
			System.out.println("Error reading CSV file");
			io.printStackTrace();
		}
		
		return absenceList;
	}
	
	public static SubList ReadSubCSV(String csvName) throws IOException {
		SubList sublist = new SubList();
		
		try (
	            Reader reader = Files.newBufferedReader(Paths.get(csvPath + csvName));
	            CSVParser csvParser = new CSVParser(reader, CSVFormat.EXCEL.withFirstRecordAsHeader());
	    ) {
			for (CSVRecord csvRecord : csvParser) {
				String date = csvRecord.get("name");
				String teachables = csvRecord.get("teachables");
				String teacherName = csvRecord.get("blacklist");
				
				
			}
		}
		
		return sublist;
	}
	
	private static ArrayList<String> parseTeachables(String teachables) {
		ArrayList<String> teachablesArray = new ArrayList<String>();
		
		String[] string = teachables.split("\n");
		
		for(int i = 0; i < string.length; i++) {
			teachablesArray.add(string[i]);
		}
		
		return teachablesArray;
	}
	
}
