import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;


/**
 * This class is a simple file writer getting a String array. 
 * Every entry in that array will be written in a separate line.
 * @author Meike Aichele - A0128157A
 *
 */
public class SimpleFileWriter {
	private String fileContent;
	private String filePath;
	
	public SimpleFileWriter(String textToWrite, String fileLocation) throws IOException {
		fileContent = textToWrite;
		filePath = fileLocation;
		if (textToWrite != null)
			writeTextToFile();
	}
	
	private void writeTextToFile() throws IOException{
		File file = new File (filePath);
		file.createNewFile();
		
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(fileContent);
		bw.flush();
		bw.close();
		
	}
}
