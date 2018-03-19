//_//

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// Works for story mode.
public class StoryParser {

	public static boolean isNumber (String str) {
		if (str.length() == 0) return false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) < '0' || str.charAt(i) > '9') return false;
		}
		return true;
	}

	public static int readInputNum(int upr) {
		// 1..upr
		while (true) {
			System.out.print("  Please make your selection: ");
			String inp = new Scanner(System.in).nextLine();
			if (isNumber(inp) && Integer.parseInt(inp) >= 1 && Integer.parseInt(inp) <= upr) {
				System.out.println("");
				return Integer.parseInt(inp);
			} else {
				System.out.println("  Invalid input!\n");
			}
		}
	}

	public static String exec(String fname) {
		if (fname.equals("_")) {
			return null;
		}
		try {
			Scanner fsc = new Scanner(new File("story/" + fname + ".txt"));
			while (fsc.hasNextLine()) {
				String l = fsc.nextLine();

				if (l.length() == 0 || l.startsWith(" ")) { // jump
					System.out.println("  " + l);
				} else if (l.startsWith("< ")) { // no-indent
					for (int i = 2; i < l.length(); i++) {
						System.out.print(l.charAt(i));
					}
					System.out.println("");
				} else if (l.startsWith("#")) { // comment
					continue;
				} else if (l.equals("@pause")) {
					new Scanner(System.in).nextLine();
				} else if (l.startsWith("@n ")) { // newline
					int n = 0;
					for (int i = 3; i < l.length(); i++) {
						n *= 10;
						n += (l.charAt(i) - '0');
					}
					for (int i = 0; i < n; i++) {
						System.out.println("");
					}
				} else if (l.startsWith("@select ")) { // branch
					String[] branches = l.split(" ");
					StoryParser.exec(branches[readInputNum(branches.length-1)]);
					continue;
				} else { // story
					System.out.print("  " + l);
					new Scanner(System.in).nextLine();
				}
			}
			fsc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}

