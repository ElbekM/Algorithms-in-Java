package Algorithms.SortingAlgorithms;

import java.util.Arrays;

/**
 * Shell Sort
 * 
 * Modified insertion sort with gaps
 * 
 * Time Complexity: O(N**2) | O(N log**2N)
 * 
 * Space Complexity: O(1) Auxiliary
 * 
 * Stable: Yes
 * 
 * @author Elbek M
 */

public class ShellSort extends SortAlgorithm {

	@Override
	public int[] sort(int[] array) {
		int gap = 1;
		while (gap < array.length / 3) {
			gap = gap * 3 + 1;
		}
		while (gap > 0) {
			insertSort(array, gap);
			gap = (gap - 1) / 3;
		}
		return array;
	}

	private int[] insertSort(int[] array, int gap) {
		int index, value;
		for (int i = gap; i < array.length; ++i) {
			value = array[i];
			index = i;
			while (index > gap - 1 && array[index - gap] > value) {
				array[index] = array[index - gap];
				index -= gap;
			}
			array[index] = value;
		}
		return array;
	}

	
	// Driver Programm
	public static void main(String[] args) {

		int[] array = { 5, 7, 2, 4, 5, 10 };
		ShellSort shellSort = new ShellSort();
		shellSort.sort(array);
		System.out.println(Arrays.toString(array));

		ShellSort randomArray = new ShellSort();
		randomArray.displayTime(randomArray.generateRandomNumbers(100000, 100000));
	}
}
