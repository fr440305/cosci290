// iterate a matrix by recursion.
// No loop statment.

public class Main {

	public static void iterateArray(int[] a, int i) {
		System.out.print(a[i] + " ");
		if (i + 1 < a.length) {
			iterateArray(a, i+1);
		} else {
			System.out.print("\n");
		}
	}

	public static void iterateMatrix(int[][] m, int col) {
		iterateArray(m[col], 0);
		if (col + 1 < m.length) {
			iterateMatrix(m, col+1);
		}
	}

	public static void main(String[] args) {
		int[][] a = {
			{1, 2, 3, 4, 5, 6},
			{7, 8, 9, 10, 11, 12}
		};
		iterateMatrix(a, 0);
	}

}

