package Algorithms.SortingAlgorithms;

/**
 * Selection Sort
 * 
 * A sorting that uses in-place comparison.
 * 
 * Time Complexity: O(N**2)
 * 
 * Space Complexity: O(1) Auxiliary
 *  
 * Stable: Yes
 */

public class SelectionSort extends SortAlgorithm {

	@Override
	public int[] sort(int[] array) {
		for (int i = 0; i < array.length - 1; ++i) {
			int minIndex = i;
			for (int j = i + 1; j < array.length; ++j) {
				if (array[minIndex] > array[j]) {
					minIndex = j;
				}
			}
			swap(array, i, minIndex);
		}
		return array;
	}

	// Driver Program
	public static void main(String[] args) {

		int[] array = { 5, 7, 2, 4, 5, 10 };
		SelectionSort selectionSort = new SelectionSort();
		selectionSort.sort(array);
		selectionSort.print(array);

		SelectionSort randomArray = new SelectionSort();
		randomArray.displayTime(randomArray.generateRandomNumbers(100000, 100000));
	}
}
