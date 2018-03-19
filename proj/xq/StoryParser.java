//_//

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// Works for story mode.
public class StoryParser {

	public static int toUint(String str) {
		if (str.length() == 0)
			return -1;
		int ret = 0;
		char ch;
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (ch < '0' || ch > '9')
				return -1;
			else {
				ret *= 10;
				ret += (ch - '0');
			}
		}
		return ret;
	}

	public static int readInputUint() {
		// 1..upr
		while (true) {
			System.out.print("  Please make your selection: ");
			String inp = new Scanner(System.in).nextLine().trim();
			int result;
			if ((result = uint(inp)) != -1 && result >= 1 && result <= upr) {
				System.out.println("");
				return result;
			} else {
				System.out.println("  Invalid input!\n");
			}
		}
	}

	public static void error (String msg) {
		System.out.println(msg);
		System.out.println("Please press C-c to exit the program.");
		new Scanner(System.in).nextLine();
	}

	public static String exec(String fname) {
		if (fname.equals("_")) {
			return null;
		}
		try {
			Scanner fsc = new Scanner(new File("story/" + fname + ".txt"));
			while (fsc.hasNextLine()) {
				String l = fsc.nextLine().trim();

				if (l.length() == 0) { // jump
					System.out.println("  " + l);
				} else if (l.startsWith("<")) { // no-indent
					System.out.println(l.substring(1).trim());
				} else if (l.startsWith("#")) { // comment
					continue;
				} else if (l.startsWith("~")) {
					System.out.println("  " + l.substring(1));
				} else if (l.equals("@pause")) {
					new Scanner(System.in).nextLine();
				} else if (l.startsWith("@n ")) { // newline
					int n = toUint(l.substring(2).trim());
					if (n == -1) {
						error(fname + "Syntax err : @n");
						return
					}
					for (int i = 0; i < n; i++) {
						System.out.println("");
					}
				} else if (l.equals("@re")) { // redo

				} else if (l.startsWith("@run ") {
					StoryParser.exec(l.substring(5).trim());
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

