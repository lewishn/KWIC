import java.io.IOException;
import java.util.Arrays;

/**
 * 
 */


/**
 * @author Meike Aichele - A1028157A
 *
 */
public class TestReader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length > 0)
		try {
			SimpleFileReader fr = new SimpleFileReader(args[0]);
			System.out.println(fr.fileContent);
			SimpleFileWriter fw = new SimpleFileWriter(fr.fileContent, args[0]+"_result");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
