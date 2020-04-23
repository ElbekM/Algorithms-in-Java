package Algorithms.SearchingAlgorithms;

/**
 * Binary Search
 * 
 * Searching x in arr[]. If x is present then return its index, 
 * otherwise return -1.
 * 
 * Complexity: O(log N)
 */

public class BinarySearch {

	public static int search(int[] array, int x) {
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int currInd = left + (right - left) / 2;
			if (array[currInd] == x) {
				return currInd;
			}
			if (array[currInd] < x) {
				left = currInd + 1;
			} else {
				right = currInd - 1;
			}
		}
		return -1;
	}

	public static int recSearch(int[] array, int x, int left, int right) {
		if (left <= right) {
			int currInd = left + (right - left) / 2;
			if (array[currInd] == x) {
				return currInd;
			}
			if (array[currInd] < x) {
				return recSearch(array, x, currInd + 1, right);
			} else {
				return recSearch(array, x, left, currInd - 1);
			}
		}
		return -1;
	}

	// Driver Programm
	public static void main(String[] args) {
		
		int[] array = { 2, 3, 4, 10, 40 };
		int find = 3;
		System.out.println(recSearch(array, find, 0, array.length - 1));
		System.out.println(search(array, find));
	}
}
