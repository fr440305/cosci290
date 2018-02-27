// Weishu Tan
// 2018-02-13

// Overview
//
// - Identifier
//   - rules for naming them
// - Data types
//   - boolean
//   - int
//   - et.c.
//   - Polisher
//     - static
//     - final
// - Scanner
//   - import before use.
//   - next() method.
// - Expression with builtin operaators
//   - add sub mul div mod



import java.util.Scanner;

public class TestInput {
	public final static double PI = 3.14159; // constant

	public static void main (String[] args) {
		// PI = 45.6; // cc err.
		String name;
		Scanner input = new Scanner(System.in);

		System.out.print("Please input your name: ");
		name = input.next();
		System.out.println("your name: " + name);

		System.out.print("How old are you: ");
		name = input.next();
		System.out.println("your age: " + name);
	}
}
