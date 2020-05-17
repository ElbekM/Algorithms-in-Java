package Algorithms.MathAlgorithms;

import java.util.Scanner;

//TODO code without recursion
public class Gcd {

	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	
	// Driver Programm
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		scanner.close();

		System.out.println(gcd(a, b));
	}
}
