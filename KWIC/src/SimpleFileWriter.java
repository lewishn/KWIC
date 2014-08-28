import java.io.File;
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
	
	/**
	 * Constructor that gets the text to write and the location where to store the text.
	 * @param textToWrite
	 * @param fileLocation
	 * @throws IOException
	 */
	public SimpleFileWriter(String textToWrite, String fileLocation) throws IOException {
		fileContent = textToWrite;
		filePath = fileLocation;
		if (textToWrite != null)
			writeTextToFile();
	}
	
	/**
	 * writes the text to write in a file using FileWriter. If there is any problem with 
	 * the file path it throws an IOException.
	 * @throws IOException
	 */
	private void writeTextToFile() throws IOException{
		File file = new File (filePath);
		file.createNewFile();
		
		FileWriter fw = new FileWriter(file);
		fw.write(fileContent);
		fw.flush();
		fw.close();
		
	}
}
