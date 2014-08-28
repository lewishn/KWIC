import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class reads the line of a text file and saves it into the public String fileContent.
 * @author Meike Aichele A0128157A
 *
 */
public class SimpleFileReader {
	
	private String filename;
	public String fileContent = "";

	/**
	 * Simple constructor that gets the filename that should be read and starts reading.
	 * @param filename
	 * @throws IOException
	 */
	public SimpleFileReader(String filename) throws IOException {
		this.filename = filename;
		readFile();
	}
	
	/**
	 * Reads a file by using the Files library and 
	 * converts the bytes that were read to a string.
	 * @throws IOException
	 */
	private void readFile() throws IOException {
		if (filename != "") {
			fileContent = new String(Files.readAllBytes(Paths.get(filename)));
			fileContent.replaceAll(",", System.lineSeparator());
		}
	}
}