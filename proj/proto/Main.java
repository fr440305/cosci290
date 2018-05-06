// weishu tan
// 2018-5-5
import java.util.Scanner;

import java.util.HashMap;
import java.util.ArrayList;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	// output
	public static String o(String p) {
		System.out.println(p);
		return new Scanner(System.in).nextLine();
	}

	public static HashMap<String, HashMap<String, String>> mapStories(String smp) {
		// smp : story map path
		HashMap<String, HashMap<String, String>> ret =
			new HashMap<String, HashMap<String, String>>();
		try {
			BufferedReader buf = new BufferedReader(new FileReader(smp));
			String line;
			int linenum = 1;
			String currentStoryFile = "";
			HashMap<String, String> nexts = null;
			while ((line = buf.readLine()) != null) {
				if (line.contains("->")) { // choice -> next story
					if (nexts == null || currentStoryFile.length() == 0) {
						System.out.println("[ERR] :: At line " + linenum);
						return null;
					}
					String choice = line.split("->")[0].trim();
					String nextStory = line.split("->")[1].trim();
					nexts.put(choice, nextStory);
					//System.out.println(currentStoryFile + " :: " + choice + " -> " + nextStory);
				} else if (line.equals("}")) {
					ret.put(currentStoryFile, nexts);
				} else if (line.endsWith("{")){
					nexts = new HashMap<String, String>();
					currentStoryFile = line.substring(0, line.length() - 2);
				}
				linenum += 1;
			}
			buf.close();
			return ret;
		} catch (FileNotFoundException errnf) {
			errnf.printStackTrace();
		} catch (IOException errio) {
			errio.printStackTrace();
		}
		return null;
	}

	public static String filePath(String title) {
		return "story." + title.replaceAll(" ", ".") + ".txt";
	}

	public static String showStory(String fp) {
		// fp : file path
		try {
			BufferedReader buf = new BufferedReader(new FileReader(filePath(fp)));
			String line;
			while ((line = buf.readLine()) != null) {
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
				} else if (line.equals("@ret")) {
					System.out.print(">>> ");
					return new Scanner(System.in).nextLine();
				} else {
					System.out.print("  " + line);
					new Scanner(System.in).nextLine();
				}
			}
			buf.close();
		} catch (FileNotFoundException errnf) {
			errnf.printStackTrace();
		} catch (IOException errio) {
			errio.printStackTrace();
		}
		return null;
	}

	public static void main(String[] x) {
		HashMap<String, HashMap<String, String>> g = mapStories("storymap.txt");
		String currentStory = "to be or not to be";
		while (true) {
			HashMap<String, String> nexts = g.get(currentStory);
			String ret = showStory(currentStory);
			if (ret == null) {
				return;
			} else if (nexts.containsKey(ret)) {
				currentStory = nexts.get(ret);
			} else {
				System.out.println("Choice not found!");
				new Scanner(System.in).nextLine();
			}
		}
	}
}

