import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class KWIC implements Action{
	
	private static ArrayList<String> ignoreList;
	private static ArrayList<String> titleList;
	
	public void execute() throws IOException {
		// TODO: enter the file path
		getWordsToIgnore("Documents/WordsToIgnore");
		getTitleList("Documents/Titles");
		getKWIC();
	}
	
	private void getKWIC() throws IOException {
		ArrayList<String> kwicOfTitles = new ArrayList<String>();
		for (int i = 0 ; i < titleList.size(); i++) {
			kwicOfTitles.addAll(stringRotate(titleList.get(i)));
		}
		// Sort the output alphabetically
		kwicOfTitles.sort(new SortWithoutCase());
		for (int i = 0; i< kwicOfTitles.size(); i++) {
			System.out.println(kwicOfTitles.get(i));
		}
		//write the result in a new file.
		setResult(kwicOfTitles);
	}
	

	private ArrayList<String> stringRotate(String stringToRotate) {
		ArrayList<String> wordList = new ArrayList<String>();
		
		String[] tokens = stringToRotate.split(" ");
		for (int i = 0; i < tokens.length; i++) {
			if (!isNonKey(tokens[i])) {
				wordList.add(stringRecombine(tokens, i));
			}
		}
		return wordList;
	}
	
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
		
		return word;
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
				// All words to ignore are converted to uppercase
				ignoreList.add(word.toUpperCase());
			}
	}
	
	/**
	 * Calls the SimpleFileReader to read the titles for KWIC from a given file.
	 * @param filepath
	 * @throws IOException 
	 */
	private void getTitleList(String filepath) throws IOException {
		titleList = new ArrayList<String>();
		if (filepath == "") return;
			SimpleFileReader reader = new SimpleFileReader(filepath);
			String [] fileContent = reader.fileContent.split(System.lineSeparator());
			for (String title : fileContent) {
				titleList.add(title);
			}
	}
	
	/**
	 * Writes the result of KWIC into a file.
	 * @param kwicOfTitles
	 * @throws IOException 
	 */
	private void setResult(ArrayList<String> kwicOfTitles) throws IOException {
		String[] textToWrite = new String[kwicOfTitles.size()];
		kwicOfTitles.toArray(textToWrite);
			SimpleFileWriter writer = new SimpleFileWriter(textToWrite);
	}
}
