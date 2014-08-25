import java.util.ArrayList;
import java.util.Collections;

public class KWIC implements Action{
	private static ArrayList<String> ignoreList;
	
	public void execute() {
		ArrayList<String> list = stringRotate();
		for (int i = 0; i< list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public ArrayList<String> stringRotate() {
		ArrayList<String> wordList = new ArrayList<String>();
		
		String test = "The Day After Tomorrow And Yesterday";
		String[] tokens = test.split(" ");
		/*
		for (int i = 0; i < tokens.length; i++) {
			if (!isNonKey(tokens[i])) {
				wordList.add(stringRecombine(tokens, i));
			}
		}
		
		
		Collections.sort(wordList);
		*/
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
	
	/*
	public boolean isNonKey(String word) {
		for (int i = 0; i < keys.length; i++) {
			if (word.equalsIgnoreCase(keys[i])) {
				return true;
			}
		}
		return false;
	}
	*/
	
	private void getWordsToIgnore() {
		ArrayList<String> list = new ArrayList<String>();
		
	}
}
