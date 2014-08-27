import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class KWIC implements Action{
	
	private static ArrayList<String> ignoreList;
	private static ArrayList<String> titleList;
	private static final String INVALID_ARGUMENT = "Invalid syntax. Usage: KWIC [title file] [words to ignore file]";
	
	//first argument : filename of titles
	//second argument: filename of words to ignore
	public String execute(String[] args) {
		if(!isArgumentValid(args)){
			return INVALID_ARGUMENT;

		}
		getTitleList(args[0]);
		getWordsToIgnore(args[1]);
		return getKwicList();
	}
	
	private boolean isArgumentValid(String[] arguments) {
		if (arguments.length != 2) {
			return false;
		}
		
		return true;
	}
	
	//Returns an ArrayList of the KWIC in sorted order
	private String getKwicList() {
		ArrayList<String> processedList = new ArrayList<String>();
		for (int i = 0 ; i < titleList.size(); i++) {
			processedList.addAll(stringRotate(titleList.get(i)));
		}
		
		Collections.sort(processedList);
		
		
		return getCombinedKwicList(processedList);
	}
	
	private String getCombinedKwicList (ArrayList<String> list) {
		String titles = "";
		for (String s: list) {
			titles += s + "\n";
		}
		return titles;
	}
	
	// For a single title, finds all possible KWIC
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
	
	//Returns the recombined rotated title
	public String stringRecombine(String[] tokens, int index) {
		String word = "";
		for (int i = index; i < tokens.length; i++) {
			word += tokens[i] + " ";
		}
		for (int i = 0; i < index; i++) {
			word += tokens[i] + " ";
		}
		word = word.substring(0, word.lastIndexOf(" "));
		
		return word;
	}
	
	private boolean isNonKey(String word) {
		return ignoreList.contains(word.toUpperCase());
	}
	
	/**
	 * Calls the SimpleFileReader to read out the words to ignore from a file.
	 * @param filepath
	 */
	private void getWordsToIgnore(String filepath) {
		ignoreList = new ArrayList<String>();
		if (filepath == "") return;
		try {
			SimpleFileReader reader = new SimpleFileReader(filepath);
			String [] fileContent = reader.fileContent.split(System.lineSeparator());
			for (String word : fileContent) {
				// All words to ignore are converted to uppercase
				ignoreList.add(word.toUpperCase());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Calls the SimpleFileReader to read the titles for KWIC from a given file.
	 * @param filepath
	 */
	private void getTitleList(String filepath) {
		titleList = new ArrayList<String>();
		if (filepath == "") return;
		try {
			SimpleFileReader reader = new SimpleFileReader(filepath);
			String [] fileContent = reader.fileContent.split(System.lineSeparator());
			for (String title : fileContent) {
				titleList.add(title);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
