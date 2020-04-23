package Algorithms.SearchingAlgorithms;

/**
 * Linear search
 * 
 * Linear searching x in arr[]. 
 * If x is present then return its index,
 * otherwise return -1.
 * 
 * Complexity: O(N)
 */

public class LinearSearch {

	public static int search(int[] array, int x) {
		for (int i = 0; i < array.length; ++i) {
			if (x == array[i]) {
				return i;
			}
		}
		return -1;
	}

	// Driver Programm
	public static void main(String[] args) {
		
		int[] array = { 3, 2, 8, 10, 9, 4, 5 };
		int find = 5;
		System.out.println(search(array, find));
	}
}
