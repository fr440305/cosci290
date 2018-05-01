public class Branch {

	public static boolean[] ctxs = new boolean[16];
	public static int[] vals = new int[16];
	public static int[] states = new int[16];
	public static int peek;

	// @if KEY .. {
	public static String parseKey (String l) {
		return (l.split(" "))[1];
	}

	// @if .. OPTION {
	// ..or..
	// } OPTION {
	public static Integer parseLabel (String l) {
		String[] tokens = l.split(" ");
		if (tokens.length <= 2) return null; // else branch.
		return Integer.parseInt(tokens[tokens.length-2]);
	}

	public static boolean isActive() {
		return (peek == 0 || states[peek] == 1);
	}

	// new if-statement
	public static void newIf (int val) {
		ctxs[peek+1] = isActive();
		vals[peek+1] = val;
		states[peek+1] = 0;
		peek += 1;
	}

	// new label
	public static void newLb (int opt) {
		if (ctxs[peek] && states[peek] != 2) {
			if (states[peek] == 0) {
				if (opt == null || opt.intValue() == vals[peek]) {
					// match
					states[peek] = 1;
				}
			} else {
				states[peek] = 2;
			}
		}
	}

	public static void endIf () {
		peek -= 1;
	}

}

