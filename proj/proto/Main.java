// weishu tan
// 2018-5-5

// stdio:
import java.util.Scanner;

// storymap:
import java.util.HashMap;
import java.util.Set;
import java.util.Map;
import java.util.ArrayList;

// fileio:
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

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
				if (line.contains("->")) { // choice -> nextStory
					if (nexts == null || currentStoryFile.length() == 0) {
						System.out.println("[ERR] :: At line " + linenum);
						return null;
					}
					String choice = line.split("->")[0].trim();
					String nextStory = line.split("->")[1].trim();
					nexts.put(choice, nextStory);
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
    return "story/" + title.replaceAll(" ", ".") + ".txt";
	}

	public static String showStory(String fp) {
		// fp : file path
		try {
			BufferedReader buf = new BufferedReader(new FileReader(filePath(fp)));
      saveProgress(fp);
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
				} else if (line.equals("@input")) {
					return "input";
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
  
  public static String getProgress(HashMap<String, HashMap<String, String>> g) {
    try {
      String ret = new BufferedReader(new FileReader("data/progress.txt")).readLine();
      if (ret != null && g.containsKey(ret)) {
        return ret; 
      } else {
        System.out.println("Cannot read the progress.");
      }
    } catch (Exception err) {
      System.out.println("Cannot read the progress.");
    }
    //error or first time:
    return "tutorial";
  }
  
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

  public static String saveProgress(String story_name) {
      try {
          //System.out.println("save progress..");
          BufferedWriter bw = new BufferedWriter(new FileWriter("data/progress.txt"));
          bw.write(story_name);
          bw.close();

          return null;
      } catch (Exception err) {
          System.out.println("saveProgress Error!" + err.toString());
      }
      return "Error";
  }

  public static String chooseRandom(HashMap<String, String> nexts) {
        Set<Map.Entry<String, String>> entries = nexts.entrySet();
        ArrayList<String> choices = new ArrayList<String>();
        for (Map.Entry<String, String> entry : entries) {
            choices.add(entry.getKey());
        }
        int num = (int)(Math.random() * choices.size());
        return choices.get(num);
  }

    public static void gameLoop(HashMap<String, HashMap<String, String>> storyMap, String currentStory) {
    }

	public static void main(String[] args) {
		HashMap<String, HashMap<String, String>> g = mapStories("storymap.txt");
		String currentStory = getProgress(g);
        // "Game Loop": 
        while (true) {
			HashMap<String, String> nexts = g.get(currentStory);
			String afterStory = showStory(currentStory);
			if (afterStory == null) {
                
				if (g.containsKey(currentStory)) {
                    if (g.get(currentStory).containsKey("")) {
                        currentStory = g.get(currentStory).get("");
                    } else {
					    System.out.println("Comming soon...");
                      delProgress();
                      return;
                    }
				} else { // die
					System.out.println("Game Over");
          delProgress();
				    return;
				}
			} else if (afterStory.equals("input")) {
                // which story after this depends on the user input
                // receive user input:
				while (true) {
					System.out.print(">>> ");
					String userInput = new Scanner(System.in).nextLine().trim();
					if (userInput.equals("exit")) {
                        System.out.println("Exiting...");
                        return; 
                    } else if (userInput.equals("rand")) {
                        String next_rand = chooseRandom(nexts);
                        currentStory = nexts.get(next_rand);
                        //System.out.println("You choose " + currentStory);
                        break;
                    } else {
					    if (nexts.containsKey(userInput)) {
						    currentStory = nexts.get(userInput);
						    if (currentStory.equals("x")) {
							System.out.println("Comming soon...");
							return;
						    }
						    break;
					    } else {
						    System.out.println("Choice not found!");
					    }
                    }
                }
			}
		} // end of the game loop
	}

}

