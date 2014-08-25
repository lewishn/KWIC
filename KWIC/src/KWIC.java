import java.util.ArrayList;
import java.util.Collections;

public class KWIC implements Action{
	private static ArrayList<String> ignoreList;
	private static ArrayList<String> titleList;
	
	public void execute() {
		getWordsToIgnore();
		getTitleList();
		
		ArrayList<String> list = stringRotate();
		for (int i = 0; i< list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	private void getKWIC() {
		for (int i = 0 ; i < titleList.size(); i++) {
			
		}
		
		
	}
	
	public ArrayList<String> stringRotate() {
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
	
	public boolean isNonKey(String word) {
		return ignoreList.contains(word.toUpperCase());
	}
	
	// All words to ignore are converted to uppercase
	private void getWordsToIgnore() {
		ArrayList<String> list = new ArrayList<String>();
		
	}
	
	private void getTitleList() {
		ArrayList<String> list = new ArrayList<String>();
	}
}
