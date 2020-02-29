import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InputCSV {
	private String csvName;
	private final String csvPath = "../subData/" + csvName;
	
	public InputCSV(String csvName) {
		this.csvName = csvName;
	}
	
	
}
