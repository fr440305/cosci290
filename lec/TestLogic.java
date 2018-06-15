import java.util.Scanner;

public class TestLogic {
	public static void main (String[] args) {
		System.out.println("Please input your grade: ");
		double grade = new Scanner(System.in).nextDouble();
		if (grade >= 90) {
			System.out.println("A");
		} else if (grade < 90 && grade >= 80) {
			System.out.println("B");
		} else if (grade >= 70) {
			System.out.println("C");
		} else if (grade >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
	}
}
