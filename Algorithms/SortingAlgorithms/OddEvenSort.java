package Algorithms.SortingAlgorithms;

import java.util.Arrays;

/**
 * Odd–even Sort
 * 
 * Modification of Bubble sort for use on parallel processors with local
 * interconnections.
 * 
 * Complexity: O(N**2)
 * 
 * Space Complexity: O(1) Auxiliary 
 * 
 * Stable: Yes
 */

public class OddEvenSort extends SortAlgorithm {

	@Override
	public int[] sort(int[] array) {
		boolean cheker = true;

		while (cheker) {
			cheker = false;
			for (int i = 0; i < array.length - 1; i += 2) {
				if (array[i] > array[i + 1]) {
					int tmp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = tmp;
					cheker = true;
				}
			}
			for (int j = 1; j < array.length - 1; j += 2) {
				if (array[j] > array[j + 1]) {
					int tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
					cheker = true;
				}
			}
		}
		return array;
	}

	// Driver Program
	public static void main(String[] args) {

		int[] array = { 5, 7, 2, 4, 5, 10 };
		OddEvenSort oddEvenSort = new OddEvenSort();
		oddEvenSort.sort(array);
		System.out.println(Arrays.toString(array));

		OddEvenSort randomArray = new OddEvenSort();
		randomArray.displayTime(randomArray.generateRandomNumbers(50000, 2000));
	}
}
