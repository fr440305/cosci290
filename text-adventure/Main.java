// weishu tan
// 2018-5-5

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		StoryMap map = new StoryMap("story/_map.txt");
		String currentStory = Progress.get(map);
		// the game loop:
		while (true) {
			if (StoryTeller.tell(currentStory) != null) {
				System.out.println("Story: "+currentStory+" not found!");
			}

			HashMap<String, String> nexts = map.get(currentStory);
			if (nexts == null) { // no nexts => die
				System.out.println("Game Over");
				Progress.clear();
				break;
			} else if (nexts.size() == 0) { // has next but empty => comming soon
				System.out.println("Comming soon...");
				Progress.clear();
				break;
			} else if (nexts.size() == 1 && nexts.containsKey("")) {
				// has unique next => fallthrough
				currentStory = nexts.get("");
			} else { // branch => get user choice
				if ((currentStory = StoryTeller.getChoiceByInput(nexts)) == null) {
					break;
				}
			}
		}
		System.out.println("Bye bye.");
	}

}
