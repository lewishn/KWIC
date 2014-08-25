import java.util.Scanner;


public class TextProcessor {
	private static final String INSUFFICIENT_ARGS_ERROR = "Error, insufficient arguments.";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String yolo;
		while (!(yolo = sc.next()).equals("exit")) {
			runAction(yolo);
		}
		sc.close();
	}
	
	private static void checkArguments(String[] args) {
		if (args.length < 2) {
			System.out.println(INSUFFICIENT_ARGS_ERROR);
		}
	}
		
	private static void runAction(String className) {
		try {
			Class actionClass = Class.forName(className);
			Object action = actionClass.getConstructor().newInstance();
			if (action instanceof Action) {
				((Action) action).execute();
			} else {
				System.out.println("Error, no such commands");
			}
		} catch (Exception e) {
			System.out.println("There seems to be an error. Please try again.");
		}
	}
}
