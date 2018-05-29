// weishu tan
// 2018-05-29

import java.util.Scanner;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class StoryTeller {

	private static String getPathOf(String title) {
		return "story/" + title.replaceAll(" ", ".") + ".txt";
	}

	public static String tell(String title) {
		Progress.save(title);
		ArrayList<String> file = Util.readFile(getPathOf(title));
		if (file == null) return "error";
		for (String line : file) {
			line = line.trim();
			if (line.length() == 0) { // jump
				System.out.println("");
			} else if (line.startsWith("<")) { // no-indent
				System.out.println(line.substring(1).trim());
			} else if (line.startsWith("#")) { // comment
				continue;
			} else if (line.startsWith(".")) {
				System.out.println("  " + line.substring(1));
			} else if (line.equals("@pause")) {
				new Scanner(System.in).nextLine();
			} else if (line.startsWith("@n ")) { // newline
				int n = Integer.parseInt(line.substring(2).trim());
				for (int i = 0; i < n; i++) {
					System.out.println("");
				}
			} else {
				System.out.print("  " + line);
				new Scanner(System.in).nextLine();
			}
		}
		return null;
	}

	private static String chooseRandom(HashMap<String, String> nexts) {
		ArrayList<String> choices = new ArrayList< >();
		for (Map.Entry<String, String> entry : nexts.entrySet()) {
			choices.add(entry.getKey());
		}
		int num = (int)(Math.random() * choices.size());
		return choices.get(num);
	}

	public static String getChoiceByInput(HashMap<String, String> nexts) {
		while (true) {
			System.out.print("\n>>> ");
			String input = new Scanner(System.in).nextLine().trim().toLowerCase();
			if (input.equals("exit") || input.equals("q")) {
				return null;
			} else if (input.equals("rand") || input.equals("r")) {
				return nexts.get(chooseRandom(nexts));
			} else if (nexts.containsKey(input)){
				return nexts.get(input);
			} else {
				System.out.println("Choice not found!");
			}
		}
	}
}
