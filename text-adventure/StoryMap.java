// weishu tan
// 2018-05-29

import java.util.ArrayList;
import java.util.HashMap;

// This class is the interpreter for story/_map.txt
public class StoryMap extends HashMap<String, HashMap<String, String>> {

	public StoryMap(String path) {
		super();

		int linenum = 1;
		String currentStory = "";
		HashMap<String, String> nexts = null;

		ArrayList<String> file = Util.readFile(path);
		if (file == null) return;

		for (String line : file) {
			if (line.endsWith("{")){
				nexts = new HashMap<String, String>();
				currentStory = line.substring(0, line.length() - 2);
			} else if (line.contains("->")) { // pattern: choice -> nextStory
				if (nexts == null || currentStory.length() == 0) {
					System.out.println("[ERR] :: At storymap.txt line " + linenum);
					return;
				}
				String choice = line.split("->")[0].trim();
				String nextStory = line.split("->")[1].trim();
				nexts.put(choice, nextStory);
			} else if (line.equals("}")) {
				if (nexts == null || currentStory.length() == 0) {
					System.out.println("[ERR] :: At storymap.txt line " + linenum);
					return;
				}
				this.put(currentStory, nexts);
			}
			linenum += 1;
		}
	}
}

