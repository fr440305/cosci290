import java.util.Scanner;

public class Main {
	public static boolean allLetters (String s) {
		for (int i = 0; i < s.length(); i ++) {
			if (!Character.isLetter(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		String name = "";
		while (true) {
			System.out.print("Please input your name: ");
			name = input.nextLine();
			if (name.length() < 2) {
				System.out.println("name should be at lease two characters. Please input another.");
				continue;
			}
			if (!allLetters(name)) {
				System.out.println("name should only consists of letters.");
			} else {
				break;
			}
		}
		System.out.println("Your name is: " + name);
	}
}
