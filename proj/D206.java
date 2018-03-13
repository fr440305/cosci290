import java.util.Scanner;

public class D206 {
	public static void eval (String line) {
		if (line.equals("quit")) {
			System.exit(0);
		} else if (line.equals("help")) {
			System.out.println("type quit to quit.");
		}

	}
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String ln;
		
		while (true) {
			System.out.print("Zombie Survival >>> ");
			eval(sc.nextLine());
		}
	}
}
