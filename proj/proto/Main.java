// weishu tan
// 2018-5-5

import java.util.Scanner;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static ArrayList<String> readFile(String filepath) {
		ArrayList<String> lines = new ArrayList< >();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filepath));
			String line = "";
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			reader.close();
			return lines;
		} catch (FileNotFoundException errnf) {
			System.out.println("Error : File " + filepath + " Not Found!");
		} catch (IOException errio) {
			System.out.println("Error : Cannot Read File " + filepath + "!");
		}
		return null;
	}

	public static String writeFile(String filepath, String content) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
			bw.write(content);
			bw.close();
			return null;
		} catch (Exception err) {
			err.printStackTrace();
		}
		return "error";
	}

	// This function read ./storymap.txt and returns a StoryMap.
	public static HashMap<String, HashMap<String, String>> mapStories(String smp) {
		// smp : story map path
		HashMap<String, HashMap<String, String>> storyMap = new HashMap< >();
		int linenum = 1;
		String currentStory = "";
		HashMap<String, String> nexts = null;
		ArrayList<String> file = readFile(smp);
		if (file == null) return null;

		for (String line : file) {
			if (line.endsWith("{")){
				nexts = new HashMap<String, String>();
				currentStory = line.substring(0, line.length() - 2);
			} else if (line.contains("->")) { // choice -> nextStory
				if (nexts == null || currentStory.length() == 0) {
					System.out.println("[ERR] :: At storymap.txt line " + linenum);
					return null;
				}
				String choice = line.split("->")[0].trim();
				String nextStory = line.split("->")[1].trim();
				nexts.put(choice, nextStory);
			} else if (line.equals("}")) {
				if (nexts == null || currentStory.length() == 0) {
					System.out.println("[ERR] :: At storymap.txt line " + linenum);
					return null;
				}
				storyMap.put(currentStory, nexts);
			}
			linenum += 1;
		}
		return storyMap;
	}

	public static String storyPath(String title) {
		return "story/" + title.replaceAll(" ", ".") + ".txt";
	}

	public static String showStory(String title) {
		saveProgress(title);
		ArrayList<String> file = readFile(storyPath(title));
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
  
	public static String getProgress(HashMap<String, HashMap<String, String>> g) {
		ArrayList<String> file = readFile("data/progress.txt");
		String ret;
		if (file != null && file.size() >= 1 && g.containsKey(ret = file.get(0))) {
			return ret;
		} else {
			System.out.println("Cannot read the progress.");
			return "tutorial";
		}
	}

	// Delete progress. Return error.
	public static void delProgress() {
		writeFile("data/progress.txt", "");
	}

	// Return error.
	public static void saveProgress(String storyTitle) {
		writeFile("data/progress.txt", storyTitle);
	}

	public static String chooseRandom(HashMap<String, String> nexts) {
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
		// the game loop:
		while (true) {
			HashMap<String, String> nexts = g.get(currentStory);
			String err = showStory(currentStory);
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
