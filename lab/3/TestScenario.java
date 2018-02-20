public class TestScenario {
	public static void main (String[] args) {
		int pr = (int)(Math.random() * 10); // 0, 1, /// , 9
		if (pr == 0) {
			// 0.1
			System.out.println("You get SSR(Super Super Rare)");
		} else if (pr >= 1 && pr < 3) {
			//0.2
			System.out.println("You get SR(Super Rare)");
		} else if (pr >= 3 && pr < 6) {
			// 0.3
			System.out.println("You get R(Rare)");
		} else {
			// 0.4
			System.out.println("You get N(Normal)");
		}
	}
}
