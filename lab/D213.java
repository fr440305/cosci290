// lab: 2018 02 13
// zomble survival

import java.util.Scanner;

public class D213 {
	public static void main (String[] args) {
		Scanner ipt = new Scanner(System.in);
		System.out.print("Tell me your name (no space containing): ");

		String name = ipt.next();
		System.out.println("Which level of difficulty you want to play?");
		System.out.println("");
		System.out.println("	1 Super Easy");
		System.out.println("	2 Insanity");
		System.out.println("	3 Please do not choose this option.");
		System.out.println("");
		System.out.println("Choose 1/2 : ");
		String level = ipt.next();

		System.out.println("=============");
		System.out.println("Player's Info");
		System.out.println("=============");
		System.out.println("");
		System.out.println("name : " + name);
		System.out.println("level: " + level);
	}
}
