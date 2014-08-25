import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


/**
 * This class is a simple file writer getting a String array. 
 * Every entry in that array will be written in a separate line.
 * @author Meike Aichele - A0128157A
 *
 */
public class SimpleFileWriter {

	private String[] fileContent; 
	
	public SimpleFileWriter(String[] textToWrite) throws IOException {
		fileContent = textToWrite;
		if (textToWrite != null)
			writeTextToFile();
	}
	
	private void writeTextToFile() throws IOException{
		FileWriter fw = new FileWriter("Result_Of_KWIC");
		BufferedWriter bw = new BufferedWriter(fw);
		for (String line : fileContent) {
			bw.write(line);
			bw.newLine();
		}
		bw.close();
	}
}
