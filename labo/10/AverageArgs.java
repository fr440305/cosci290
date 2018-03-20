import java.util.Scanner;
import java.util.ArrayList;

public class AverageArgs {

    // This function takes an array with
    // integers and calculates their average.
    // if arr is empty, then output zero.
    public static int average (int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length; // may lose presice.
    }

    // This function takes an array with
    // doubles and calculates their average.
    // if arr is empty, then output zero.
    public static double average (double[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }
  
    // This function takes an array with
    // doubles and calculates their average.
    // if arr is empty, then output zero.
    public static double average (ArrayList<Double> list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum / list.size();
    }


    public static void main (String[] args) {
        ArrayList<Double> list = new ArrayList<Double>();
        for (int i = 0; i < args.length; i++) {
            list.add(Double.parseDouble(args[i]));
        }
        System.out.println("The average is: " + Double.toString(average(list)));
    }
}
