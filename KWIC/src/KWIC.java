import java.util.ArrayList;
import java.util.Collections;

public class KWIC implements Action{
	private static ArrayList<String> ignoreList;
	private static ArrayList<String> titleList;
	
	public void execute() {
		//getWordsToIgnore();
		getTitleList();
		getKWIC();
		//print or return 
	}
	
	private ArrayList<String> getKWIC() {
		ArrayList<String> processedList = new ArrayList<String>();
		for (int i = 0 ; i < titleList.size(); i++) {
			processedList.addAll(stringRotate(titleList.get(i)));
		}
		
		Collections.sort(processedList);
		return processedList;
	}
	
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
	private void getWordsToIgnore(String fileName) {
		ArrayList<String> list = new ArrayList<String>();
		
	}
	
	private void getTitleList(String fileName) {
		ArrayList<String> list = new ArrayList<String>();
	}
}
