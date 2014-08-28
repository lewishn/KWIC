import java.util.ArrayList;


public class CircularShift {
	/**
	 * Returns an unsorted ArrayList of the KWIC
	 * @return
	 */
	public static ArrayList<String> getKwicList(ArrayList<String> titleList) {
		ArrayList<String> processedList = new ArrayList<String>();
		for (int i = 0 ; i < titleList.size(); i++) {			
			processedList.addAll(stringRotate(titleList.get(i)));
		}
		
		return processedList;
	}
	
	/**
	 *  For a single title, finds all possible KWIC
	 * @param title
	 * @return
	 */
	private static ArrayList<String> stringRotate(String title) {
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
	private static String stringRecombine(String[] tokens, int index) {
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
	
	private static boolean isNonKey(String word) {
		return KWIC.getIgnoreList().contains(word.toUpperCase());
	}
}
