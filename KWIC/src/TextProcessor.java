import java.util.Arrays;

public class TextProcessor {
	private static final String USAGE_PROMPT = "Usage: [TextProcessor] [Program name] [Arguments]";
	
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println(USAGE_PROMPT);
		} else {
			runAction(args);
		}
		
		System.exit(0);
	}
	private static void runAction(String[] args) {
		String feedback = "";
		try {
			Class actionClass = Class.forName(args[0]);
			Object action = actionClass.getConstructor().newInstance();
			if (action instanceof Action) {
				long startTime = System.currentTimeMillis();
				((Action) action).execute(Arrays.copyOfRange(args, 1, args.length));
				long endTime = System.currentTimeMillis();
				System.out.println("Done! That took " + (endTime - startTime) + " milliseconds");
			} else {
				feedback = "Error, no such program";
			}
		} catch (Exception e) {
			feedback = "There seems to be an error. Please try again.";
		} finally {
			printFeedback(feedback);
		}
	}
	
	private static void printFeedback(String s) {
		System.out.println(s);
	}
}
