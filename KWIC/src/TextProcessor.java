/**
 * The main class
 * @author Lewis Haris Nata A0099727J
 *
 */

import java.io.IOException;
import java.util.Arrays;

public class TextProcessor {
	private static final String MESSAGE_NO_PROGRAM = "Error, no such program";
	private static final String MESSAGE_IO_ERROR = "Files specified do not exist";
	private static final String MESSAGE_ERROR = "There seems to be an error. Please try again.";
	private static final String MESSAGE_USAGE_PROMPT = "Usage: [TextProcessor] [Program name] [Arguments]";
	private static final String MESSAGE_PROGRAM_RUN_TIME = "Done! That took %s milliseconds.";
	
	public static void main(String[] args) {
		if (args.length == 0) {
			printFeedback(MESSAGE_USAGE_PROMPT);
		} else {
			runAction(args);
		}
		
		System.exit(0);
	}
	private static void runAction(String[] args) {
		try {
			Class<?> actionClass = Class.forName(args[0]);
			Object action = actionClass.getConstructor().newInstance();
			if (action instanceof Action) {
				long startTime = System.currentTimeMillis();
				String feedback = ((Action) action).execute(Arrays.copyOfRange(args, 1, args.length));
				long endTime = System.currentTimeMillis();
				printFeedback(feedback);
				printFeedback(String.format(MESSAGE_PROGRAM_RUN_TIME, endTime - startTime));
			} else {
				printFeedback(MESSAGE_NO_PROGRAM);
			}
		} catch (IOException e) {
			printFeedback(MESSAGE_IO_ERROR);
		} catch (Exception e) {
			printFeedback(MESSAGE_ERROR);
		} 
	}
	
	public static void printFeedback(String s) {
		System.out.println(s);
	}
}
