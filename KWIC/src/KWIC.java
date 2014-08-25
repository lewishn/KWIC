import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class KWIC implements Action{
	
	private static ArrayList<String> ignoreList;
	private static ArrayList<String> titleList;
	
	public void execute() {
		// TODO: enter the file path
		getWordsToIgnore("");
		getTitleList("");
		
		ArrayList<String> list = stringRotate();
		for (int i = 0; i< list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	private void getKWIC() {
		for (int i = 0 ; i < titleList.size(); i++) {
			
		}
		
		
	}
	
	private ArrayList<String> stringRotate() {
		ArrayList<String> wordList = new ArrayList<String>();
		
		String test = "The Day After Tomorrow And Yesterday";
		String[] tokens = test.split(" ");
		for (int i = 0; i < tokens.length; i++) {
			if (!isNonKey(tokens[i])) {
				wordList.add(stringRecombine(tokens, i));
			}
		}
		
		return wordList;
	}
	
	private String stringRecombine(String[] tokens, int index) {
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
