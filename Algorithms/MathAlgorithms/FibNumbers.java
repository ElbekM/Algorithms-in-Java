package Algorithms.MathAlgorithms;

import java.util.Scanner;

/**
 * 
 * @author Elbek M
 */

public class FibNumbers {

	public static int fib(int n) {
		int prev = 1;
		int curr = 1;
		for (int i = 0; i < n - 2; ++i) {
			int tmp = curr;
			curr = prev + curr;
			prev = tmp;
		}
		return curr;
	}
	
	public static int fibRec(int n) {
		if (n == 0){
	        return 0;
	    }
	    if (n == 1){
	        return 1;
	    }
	    return fibRec(n - 1) + fibRec(n - 2);
	}
	
	
	// Driver Programm
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		
		System.out.println(fibRec(n));
		System.out.println(fib(n));
	}

}
