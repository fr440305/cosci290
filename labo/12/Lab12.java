/*
 * Weishu Tan, 882984689
 * East Los Angeles College

	Lab 12

	Directions:
	1. This application has bugs. Edit my code so that the program compiles and runs.
	2. Comment every line of code.
	3. Add code or modify the code so that the following output is achieved:

	        *
	      * * * 
	    * * * * *
	  * * * * * * *
	* * * * * * * * *
	  * * * * * * *
	    * * * * *
	      * * *
	        *


  * * * * *
	  * * * * 
	    * * * 
	      * * 
	        *

	4. Fix the indentation of the code. 

	Note:
	Clean java code has:
	 proper indentation
	 variable declaration at the beginning of the program
	 class name starts with a capital
	 comments that explains the logic

*/

public class Lab12{

	// The main funtion draw a diamond,
	// and then the function calls printTriangle
	// to draw a triangle.
	public static void main(String[] args) {
		
		// According to the specification,
		// the diamond is consisted of 9 coloums of asterisks.
		// Therefore we iterate from 0 to 8.
		for(int row = 0; row < 9; row++) {
			
			// For each line of the graph, it consists of two parts:
			// the leading spaces and the asterisks.
			// The relationship among the line number(row),
			// the number of leading spaces(leading_spaces_num),
			// and the number of asterisks(asters_num)
			// can be shown as the following table:
			//   row    : 0 1 2 3 4 5 6 7 8
			//   spaces : 4 3 2 1 0 1 2 3 4 
			//   asters : 1 3 5 7 9 7 5 3 1
			// Notice that the graph is symmetric about row 4.
			// Hence the line of the n-th row should be the same
			// as the (8 - n)-th row.
			// Therefore, spaces = 4 - row when 0 <= row <= 4,
			// or 4 - (8 - row) when 4 < row <= 8.
			// asters = 2 * row + 1 when 0 <= row <= 4,
			// or 2 * (8 - row) + 1 when 4 < row <= 8.
			int leading_spaces_num = 4 - ((row <= 4) ? row : (8 - row));
			int asters_num = 2 * ((row <= 4) ? row : (8 - row)) + 1;
			
			// "Space" means "  " (two of ascii spaces).
			for(int sp = 0; sp <= leading_spaces_num; sp++) {
				System.out.print("  ");
			}
			
			// "Aster" means " *".
			for(int aster = 0; aster < asters_num; aster++) {
				System.out.print(" *");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		printTriangle();
	}

	// This function will draw a right triangle on the terminal.
	public static void printTriangle() {
		
		// The graph has 6 lines, therefore we iterate from 0 to 5.
		for (int row = 0; row < 6; row ++) {
			
			// For each line, it has (row + 1) leading spaces, ...
			for (int sp = 0; sp < row + 1; sp++) {
				System.out.print("  ");
			}
			
			// ... and (5 - row) asterisks.
			for (int aster = 0; aster < 5 - row; aster++) {
				System.out.print(" *");
			}
			System.out.print("\n");
		}
	}	
}

