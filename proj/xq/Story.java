// 882984689

import java.util.Scanner;
import java.io.File;

// Works for story mode.
public class Story {

	public static int getValue (String key) {
		//System.out.println("Story.getValue");
		if (key.equals("Input")) {
			return new Scanner(System.in).nextInt();
		}
		System.out.println("TODO Story.getValue");
		return -1;
	}

	public static int setValue (String key, int val) {
		System.out.println("setValue :: key val == " + key + " " + val);
		return -1;
	}

	// return @re or not.
	public static boolean eachLine (String fname, Scanner fsc) {
		while (fsc.hasNextLine()) {
			String l = fsc.nextLine().trim();
			//System.out.println("Story.eachLine " + l);
			if (l.startsWith("@if ")) { // start if
				if (Branch.isActive()) {
					Branch.newIf(getValue(Branch.parseKey(l)));
					Branch.newLb(Branch.parseLabel(l));
				} else {
					Branch.newIf(-1);
				}
				continue;
			} else if (l.startsWith("}") && l.endsWith("{")) { // labels
				Branch.newLb(Branch.parseLabel(l));
				continue;
			} else if (l.equals("}")) { // endif
				Branch.endIf();
				continue;
			}
			if (Branch.isActive()) {
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
					int n = Integer.parseInt(l.substring(2).trim());
					for (int i = 0; i < n; i++) {
						System.out.println("");
					}
				} else if (l.startsWith("@run ")) {
					String sub_fname = l.substring(("@run ").length()).trim();
					if (sub_fname.equals("$")) {
						// return
						return false;
					}
					Story.exec(l.substring(4).trim());
				} else if (l.equals("@re")) {
					return true;
				} else if (l.startsWith("@set ")) {
					setValue(l.split(" ")[0], Integer.parseInt(l.split(" ")[1]));
				} else if (l.startsWith("@battle ")) {
					Battle.exec(l.substring(("@battle ").length()).trim());
				} else {
					System.out.print("  " + l);
					new Scanner(System.in).nextLine();
				}
			}
		}
		return false;
	}

	public static String exec(String fname) {
		if (fname.equals("_")) {
			return null;
		}
		try {
			boolean re;
			do {
				Scanner fsc = new Scanner(new File("./story/" + fname + ".txt"));
				re = Story.eachLine(fname, fsc);
				fsc.close();
			} while (re);
		} catch (Exception e) {
			System.out.println("err!");
			e.printStackTrace();
		}
		return null;
	}
}

