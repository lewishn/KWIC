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
	
	public boolean isNonKey(String word) {
		return ignoreList.contains(word.toUpperCase());
	}
	
	// All words to ignore are converted to uppercase
	private void getWordsToIgnore(String fileName) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("A");
		ignoreList = list;
	}
	
	private void getTitleList(String fileName) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("A apple a Day Dkeeps dkeeps a doctor away");
		titleList = list;
	}
}
