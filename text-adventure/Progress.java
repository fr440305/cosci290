// weishu tan
// 2018-05-29

import java.util.HashMap;
import java.util.ArrayList;

public class Progress {

	public static String get(StoryMap map) {
		ArrayList<String> file = Util.readFile("data/progress.txt");
		String ret;
		if (file != null && file.size() >= 1 && map.containsKey(ret = file.get(0))) {
			return ret;
		} else {
			System.out.println("Cannot read the progress.");
			return "tutorial";
		}
	}

	public static void clear() {
		Util.writeFile("data/progress.txt", "");
	}

	public static void save(String storyTitle) {
		String err = Util.writeFile("data/progress.txt", storyTitle);
		if (err != null) {
			System.out.println(
				"Warning: The story progress "+
				"cannot be saved for unknown reason."
			);
		} else {
			System.out.println(
				"Story progress has already been saved."+
				"Next time the game will start from `"+
				storyTitle+"`."
			);
		}
	}
}

