package Algorithms.SortingAlgorithms;

import java.util.Arrays;

/**
 * Cocktail sort
 * 
 * A bidirectional bubble sort.
 * 
 * Time Complexity: O(N**2)
 * 
 * Space Complexity: O(1) Auxiliary
 * 
 * Stable: Yes
 */

public class CocktailSort extends SortAlgorithm {

	@Override
	public int[] sort(int[] array) {
		int left = 0, right = array.length - 1;

		while (left <= right) {
			for (int i = left; i < right; ++i) {
				if (array[i] > array[i + 1]) {
					swap(array, i, i + 1);
				}
			}
			right--;

			for (int j = right; j > left; j--) {
				if (array[j] < array[j - 1]) {
					swap(array, j, j - 1);
				}
			}
			left++;
		}
		return array;
	}

	// Driver Program
	public static void main(String[] args) {

		int[] array = { 5, 7, 2, 4, 5, 10 };
		CocktailSort cocktailSort = new CocktailSort();
		cocktailSort.sort(array);
		System.out.println(Arrays.toString(array));

		CocktailSort randomArray = new CocktailSort();
		randomArray.displayTime(randomArray.generateRandomNumbers(100000, 100000));
	}
}
