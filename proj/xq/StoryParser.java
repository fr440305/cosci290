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
			if ((result = toUint(inp)) != -1) {
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

	// return @re or not.
	public static boolean execLine (String fname, Scanner fsc) {
                //System.out.println("StoryParser.execline");
		while (fsc.hasNextLine()) {
			String l = fsc.nextLine().trim();
                        //System.out.println(l);

			if (l.length() == 0) { // jump
				System.out.println("");
			} else if (l.startsWith("<")) { // no-indent
				System.out.println(l.substring(1).trim());
			} else if (l.startsWith("#")) { // comment
				continue;
			} else if (l.startsWith(".")) {
				System.out.println("  " + l.substring(1));
			} else if (l.equals("@pause")) {
				new Scanner(System.in).nextLine();
			} else if (l.startsWith("@n ")) { // newline
				int n = toUint(l.substring(2).trim());
				if (n == -1) {
					error(fname + "Syntax err : @n");
					return false; // err => !re
				}
				for (int i = 0; i < n; i++) {
					System.out.println("");
				}
			} else if (l.startsWith("@use ")) {
				String sub_fname = l.substring(4).trim();
				if (sub_fname.equals("$")) {
					return false;
				}
				StoryParser.exec(l.substring(4).trim());
			} else if (l.equals("@re")) {
				return true;
			} else {
				System.out.print("  " + l);
				new Scanner(System.in).nextLine();
			}
		}
		return false;
	}

	public static String exec(String fname) {
                //System.out.println("Story.exec");
		if (fname.equals("_")) {
			return null;
		}
		try {
                        boolean re;
			do {
                                //System.out.println("./story/" + fname + ".txt");
				Scanner fsc = new Scanner(new File("./story/" + fname + ".txt"));
				re = StoryParser.execLine(fname, fsc);
				fsc.close();
			} while (re);
		//} catch (FileNotFoundException e) {
		} catch (Exception e) {
                        System.out.println("err!");
			e.printStackTrace();
		}
		return null;
	}
}

