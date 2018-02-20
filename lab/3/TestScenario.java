import java.util.Scanner;

public class TestScenario {
	public static void main (String[] args) {
		int pr = (int)(Math.random() * 10); // 0, 1, /// , 9
		if (pr == 0) {
			// 0.1
			System.out.println("You get SSR(Super Super Rare): A Big Dragon");
		} else if (pr >= 1 && pr < 3) {
			//0.2
			System.out.println("You get SR(Super Rare): A Tank");
		} else if (pr >= 3 && pr < 6) {
			// 0.3
			System.out.println("You get R(Rare): A Gun");
		} else {
			// 0.4
			System.out.print(
				"You get N(Normal). Choose one below\n"+
				"\n"+
				"\t 1 Knife\n"+
				"\t 2 Sword\n"+
				"\t 3 Axe\n"+
				"\nType Your choice(1 or 2 or 3) and press enter:"
			);
			int choice = new Scanner(System.in).nextInt();
			if (choice == 1) {
				System.out.println("You get a normal knife.");
			} else if (choice == 2) {
				System.out.println("You get a normal sword.");
			} else if (choice == 3) {
				System.out.println("You get a normal axe.");
			} else {
				System.out.println("You get nothing because "+choice+" is not a choice.");
			}
		}
	}
}
