package hibernate_javase_1.console_utils;

import java.util.Scanner;

public class ConsoleUtils {

	public static void waitForEnter() {
		System.out.println("Press \"ENTER\" to continue...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		scanner.close();
	}

}
