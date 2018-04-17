//_//

public class Main {
	public static void main(String[] x) {
		//StoryParser.exec("1");
		if (x.length == 1) {
			Story.exec(x[0]);
		} else {
			Story.exec("0");
		}
	}
}
