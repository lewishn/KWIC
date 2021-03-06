import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class KWIC implements Action{
	private static ArrayList<String> ignoreList;
	private static ArrayList<String> titleList;
	private static final String INVALID_ARGUMENT = "Invalid syntax. Usage: KWIC [title file] [words to ignore file]";
	
	/**
	 * first argument : filename of titles
	 * second argument: filename of words to ignore
	 * @author Lewis Haris Nata A0099727J
	 */
	public String execute(String[] args) throws IOException{
		if(!isArgumentValid(args)){
			return INVALID_ARGUMENT;

		} else {
			getTitleList(args[0]);
			getWordsToIgnore(args[1]);
			ArrayList<String> unsortedResult = CircularShift.getKwicList(titleList);
			String result = Alphabetizer.combinedSortedList(unsortedResult);
			setResult(result, args[0]);
			return result;
		}
	}
	
	/**
	 * Getter returns the list of words to ignore without reading it from a file.
	 * Could be null if the program hasn't read something from a file before.
	 * @return
	 * @author Lewis Haris Nata A0099727J
	 */
	public static ArrayList<String> getIgnoreList() {
		return ignoreList;
	}
	
	/**
	 * Getter returns the list of titles without reading it from a file.
	 * Could be null if the program hasn't read something from a file before.
	 * @return
	 * @author Lewis Haris Nata A0099727J
	 */
	public static ArrayList<String> getTitleList() {
		return titleList;
	}
	
	/**
	 * Gives back a boolean: if the incoming string array has exactly 2 entries, that bool is true.
	 * @param arguments
	 * @return
	 * @author Lewis Haris Nata A0099727J
	 */
	private boolean isArgumentValid(String[] arguments) {
		return arguments.length == 2;
	}
	

	
	
	
	/**
	 * Calls the SimpleFileReader to read out the words to ignore from a file.
	 * @param filepath
	 * @throws IOException
	 * @author Meike Aichele A0128157A 
	 */
	private void getWordsToIgnore(String filepath) throws IOException {
		ignoreList = new ArrayList<String>();
		if (filepath == "") return;
		SimpleFileReader reader = new SimpleFileReader(filepath);
		String [] fileContent = reader.fileContent.split(System.lineSeparator());
		for (String word : fileContent) {
			// All words to ignore are converted to upper case
			ignoreList.add(word.toUpperCase());
		}
	}
	
	/**
	 * Calls the SimpleFileReader to read the titles for KWIC from a given file.
	 * @param filepath
	 * @throws IOException 
	 * @author Meike Aichele A0128157A
	 */
	private void getTitleList(String filepath) throws IOException {
		if (filepath == "") return;
		SimpleFileReader reader = new SimpleFileReader(filepath);
		String [] fileContent = reader.fileContent.split(System.lineSeparator());
		titleList = new ArrayList<String>(Arrays.asList(fileContent));
	}
	
	
	/**
	 * Writes the result of KWIC into a file.
	 * @param kwicOfTitles
	 * @throws IOException 
	 * @author Meike Aichele A0128157A
	 */
	private void setResult(String kwicOfTitles, String loc) throws IOException {
		new SimpleFileWriter(kwicOfTitles, loc + "_result");
	}
}
