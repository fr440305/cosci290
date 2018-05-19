// weishu tan
// 2018-5-5

// Summary
//
// - storymap.txt
// - StoryName
// - StoryTitle
// - Progress
// - Choice
// - StoryMap : HashMap<String, HashMap<String, String>>
// - Nexts : HashMap<String, String>

// stdin:
import java.util.Scanner;

// storymap:
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

// fileio:
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	// This function read ./storymap.txt and returns a StoryMap.
	public static HashMap<String, HashMap<String, String>> mapStories(String smp) {
		// smp : story map path
		HashMap<String, HashMap<String, String>> ret =
			new HashMap<String, HashMap<String, String>>();

		try {
			BufferedReader buf = new BufferedReader(new FileReader(smp));
			String line;
			int linenum = 1;
			String currentStory = "";
			HashMap<String, String> nexts = null;
			while ((line = buf.readLine()) != null) {
				if (line.endsWith("{")){
					nexts = new HashMap<String, String>();
					currentStory = line.substring(0, line.length() - 1).trim();
				} else if (line.contains("->")) { // choice -> nextStory
					if (nexts == null || currentStory.length() == 0) {
						System.out.println("[ERR] :: At line " + linenum);
						return null;
					}
					String choice = line.split("->")[0].trim();
					String nextStory = line.split("->")[1].trim();
					nexts.put(choice, nextStory);
				} else if (line.equals("}")) {
				
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
		return "story/" + title.replaceAll(" ", ".") + ".txt";
	}

	public static String showStory(String title) {
		try {
			BufferedReader buf = new BufferedReader(new FileReader(filePath(title)));
			saveProgress(title);
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
				} else {
					System.out.print("  " + line);
					new Scanner(System.in).nextLine();
				}
			}
			buf.close();
		} catch (FileNotFoundException errnf) {
			return "nofile";
		} catch (IOException errio) {
			return "errio";
		}
		return null;
	}
  
	public static String getProgress(HashMap<String, HashMap<String, String>> g) {
		try {
			String ret = new BufferedReader(new FileReader("data/progress.txt")).readLine();
			if (ret != null && g.containsKey(ret)) {
				return ret; 
			} else {
				System.out.println("Cannot read the progress.");
			}
		} catch (Exception err) { // not a big deal
			System.out.println("Cannot read the progress.");
		}
		//error or first time:
		return "tutorial";
	}
  
	// Delete progress.
	public static String delProgress() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("data/progress.txt"));
			bw.write("");
			bw.close();
			return null;
		} catch (Exception err) {
			err.printStackTrace();
		}
		return "Error";
	}

	public static String saveProgress(String storyName) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("data/progress.txt"));
			bw.write(storyName);
			bw.close();
			return null;
		} catch (Exception err) {
			System.out.println("saveProgress Error!" + err.toString());
		}
		return "error";
	}

	public static String chooseRandom(HashMap<String, String> nexts) {
		ArrayList<String> choices = new ArrayList<String>();
		for (Map.Entry<String, String> entry : nexts.entrySet()) {
			choices.add(entry.getKey());
		}
		int num = (int)(Math.random() * choices.size());
		return choices.get(num);
	}

	public static String getChoiceByInput(HashMap<String, String> nexts) {
		while (true) {
			System.out.print("\n>>> ");
			String input = new Scanner(System.in).nextLine().trim();
			if (input.equals("exit")) {
				return null;
			} else if (input.equals("rand")) {
				return nexts.get(chooseRandom(nexts));
			} else if (nexts.containsKey(input)){
				return nexts.get(input);
			} else {
				System.out.println("Choice not found!");
			}
		}
	}

	public static void main(String[] args) {
		HashMap<String, HashMap<String, String>> g = mapStories("storymap.txt");
		String currentStory = getProgress(g);
		// "Game Loop": 
		while (true) {
			HashMap<String, String> nexts = g.get(currentStory);
			String afterStory = showStory(currentStory);
			if (nexts == null) { // no nexts => die
				System.out.println("Game Over");
				delProgress();
				return;
			} else if (nexts.size() == 0) { // has next but empty => comming soon
				System.out.println("Comming soon...");
				delProgress();
				return;
			} else if (nexts.size() == 1 && nexts.containsKey("")) {
				// has unique next => fallthrough
				currentStory = nexts.get("");
			} else { // branch => get user choice
				if ((currentStory = getChoiceByInput(nexts)) == null) {
					System.out.println("Exiting...");
					return;
				}
			}
		}
	}

}
