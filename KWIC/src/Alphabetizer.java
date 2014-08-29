/**
 * 
 * @author Lewis Haris Nata A0099727J
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Alphabetizer {
	public static class SortWithoutCase implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			return o1.toLowerCase().compareTo(o2.toLowerCase());
		}
	}

	
	public static String combinedSortedList(ArrayList<String> list) {
		return combineListToString(sort(list));
	}
	
	private static ArrayList<String> sort(ArrayList<String> list) {
		Collections.sort(list, new SortWithoutCase());
		return list;
	}
	
	private static String combineListToString(ArrayList<String> list) {
		String[] arrList = new String[list.size()];		
		list.toArray(arrList);
		String results = Arrays.toString(arrList).replaceAll(", "  , System.lineSeparator());
		return results.replace("[", ""). replace("]", "");

	}
}
