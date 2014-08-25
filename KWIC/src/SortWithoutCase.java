import java.util.Comparator;

/**
 * Compares two Strings without considering the case.
 * @author Meike Aichele - A0128157A
 *
 */
public class SortWithoutCase implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.toLowerCase().compareTo(o2.toLowerCase());
	}
}
