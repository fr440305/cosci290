import java.util.Scanner;

public class AveragePrompt {

    // This function takes an array with
    // integers and calculates their average.
    public static int average (int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length; // may lose presice.
    }

    // This function takes an array with
    // doubles and calculates their average.
    public static double average (double[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }

    public static void main (String[] args) {
        double[] arr = new double[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Please input the " + Integer.toString(i) + "-th number: ");
            arr[i] = new Scanner(System.in).nextDouble();
        }
        System.out.println("The average is: " + Double.toString(average(arr)));
    }
}
