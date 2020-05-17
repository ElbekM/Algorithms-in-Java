package Algorithms.MathAlgorithms;

import java.util.Scanner;

public class Factorial {

	public static int factorial(int x) {
		if (x <= 1) {
			return 1;
		}
		return x * factorial(x - 1);
	}

	public static int factorialRec(int x) {
		int result = 1;
		for (int i = 1; i <= x; ++i) {
			result *= i;
		}
		return result;
	}

	
	// Driver Programm
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();

		System.out.println(factorial(n));
		System.out.println(factorialRec(n));
	}
}
