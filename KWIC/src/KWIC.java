import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class KWIC implements Action{
	
	private static ArrayList<String> ignoreList;
	private static ArrayList<String> titleList;
	private static final String INVALID_ARGUMENT = "Invalid syntax. Usage: KWIC [title file] [words to ignore file]";
	
	/**
	 * first argument : filename of titles
	 * second argument: filename of words to ignore
	 */
	public String execute(String[] args) throws IOException{
		if(!isArgumentValid(args)){
			return INVALID_ARGUMENT;

		} else {
			getTitleList(args[0]);
			getWordsToIgnore(args[1]);
			String result = getKwicList();
			setResult(result, args[0]);
			return result;
		}
	}
	
	/**
	 * Gives back a boolean: if the incoming string array has exactly 2 entries, that bool is true.
	 * @param arguments
	 * @return
	 */
	private boolean isArgumentValid(String[] arguments) {
		return arguments.length == 2;
	}
	
	/**
	 * Returns an ArrayList of the KWIC in sorted order
	 * @return
	 */
	private String getKwicList() {
		ArrayList<String> processedList = new ArrayList<String>();
		for (int i = 0 ; i < titleList.size(); i++) {			
			processedList.addAll(stringRotate(titleList.get(i)));
		}
		
		// Sorts the list alphabetically
		Collections.sort(processedList);
	
		String[] resultStrings = new String[processedList.size()];
		processedList.toArray(resultStrings);
		String kwicResult = Arrays.toString(resultStrings).replaceAll(",", System.lineSeparator());

		return kwicResult.replace("[", ""). replace("]", "");
	}
	
	/**
	 *  For a single title, finds all possible KWIC
	 * @param title
	 * @return
	 */
	public ArrayList<String> stringRotate(String title) {
		ArrayList<String> wordList = new ArrayList<String>();
		String[] tokens = title.split(" ");
		for (int i = 0; i < tokens.length; i++) {
			if (!isNonKey(tokens[i])) {
				wordList.add(stringRecombine(tokens, i));
			}
		}
		return wordList;
	}
	
	/**
	 * Returns the recombined rotated title
	 * @param tokens
	 * @param index
	 * @return
	 */
	private String stringRecombine(String[] tokens, int index) {
		// Keyword must start with upper case letter
		String word = tokens[index].substring(0, 1).toUpperCase() + tokens[index].substring(1) + " ";
		for (int i = index + 1; i < tokens.length; i++) {
			word += tokens[i] + " ";
		}
		for (int i = 0; i < index; i++) {
			word += tokens[i] + " ";
		}
		word = word.substring(0, word.lastIndexOf(" "));
		return new String(word);
	}
	
	private boolean isNonKey(String word) {
		return ignoreList.contains(word.toUpperCase());
	}
	
	
	/**
	 * Calls the SimpleFileReader to read out the words to ignore from a file.
	 * @param filepath
	 * @throws IOException 
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
	 */
	private void setResult(String kwicOfTitles, String loc) throws IOException {
		new SimpleFileWriter(kwicOfTitles, loc + "_result");
	}
}
