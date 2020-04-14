package Algorithms.SortingAlgorithms;

/**
 * Bubble Sort
 * 
 * A naive sorting that compares and swaps adjacent elements.
 * 
 * Time Complexity: O(N**2)
 * 
 * Space Complexity: O(1) Auxiliary
 * 
 * Stable: Yes
 */

public class BubbleSort extends SortAlgorithm {

	@Override
	public int[] sort(int[] array) {
		for (int end = array.length - 1; end > 0; end--) {
			for (int j = 0; j < end; ++j) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
				}
			}
		}
		return array;
	}

	// Driver Program
	public static void main(String[] args) {

		int[] array = { 5, 7, 2, 4, 5, 10 };
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort(array);
		bubbleSort.print(array);

		BubbleSort randomArray = new BubbleSort();
		randomArray.displayTime(randomArray.generateRandomNumbers(100000, 100000));
	}
}
