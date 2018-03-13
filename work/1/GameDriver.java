// WEISHU TAN

import java.util.Scanner;

public class GameDriver {
	public static void main (String[] args) {
		System.out.println(
			"\n\n"+
			"  ____ ___  ________    _____ ______ |  |   ____  \n"+
			"_/ __ \\\\  \\/  /\\__  \\  /     \\\\____ \\|  | _/ __ \\ \n"+
			"\\  ___/ >    <  / __ \\|  Y Y  \\  |_> >  |_\\  ___/ \n"+
			" \\___  >__/\\_ \\(____  /__|_|  /   __/|____/\\___  >\n"+
			"     \\/      \\/     \\/      \\/|__|             \\/ \n"+
			"\n\n"
		);
		int zbnum = 2 + (int)(Math.random() * 13); // number of zombies.
		System.out.println("There are " + zbnum + " zombies!");

		while (zbnum > 0) {	
			System.out.println("type j following an enter to kill zombies!");
			if ((new Scanner(System.in)).nextLine().equals("j")) {
			zbnum -= 1;
				System.out.println("\nOne zombie has been killed!");
				System.out.println("There are " + zbnum + " zombies!");
			} else {
				System.out.println("You should press j but you don't so you die.");
				return;
			}
		}

		System.out.println("You win!");

	}
}

