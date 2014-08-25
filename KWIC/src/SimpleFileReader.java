import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class reads the line of a text file and saves it into the public String fileContent.
 * @author Meike Aichele A0128157A
 *
 */
public class SimpleFileReader {
	
	private String filename;
	public String fileContent = "";

	public SimpleFileReader(String filename) throws IOException {
		this.filename = filename;
		readFile();
	}
	
	private void readFile() throws IOException {
		if (filename != "") {
			FileReader reader = new FileReader(filename);
			BufferedReader br = new BufferedReader(reader);
			String currentLine = br.readLine();
			while(currentLine != null)
			{
				fileContent += currentLine + System.lineSeparator();
				currentLine = br.readLine();
			}
			br.close();
		}
	}
}
