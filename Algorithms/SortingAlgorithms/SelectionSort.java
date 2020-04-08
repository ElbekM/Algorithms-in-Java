package Algorithms.SortingAlgorithms;

import java.util.Arrays;

/**
 * Selection Sort
 * 
 * A sorting that uses in-place comparison.
 * 
 * Time Complexity:  O(N**2)
 * 
 * Space Complexity: O(1) Auxiliary
 * 
 * Stable: Yes
 * 
 * @author ElbekM
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
			int tmp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = tmp;
		}
		return array;
	}
	
	
	//Driver Program
	public static void main(String[] args) {
		
		int[] array = {5, 7, 2, 4, 5, 10};
		SelectionSort selectionSort = new SelectionSort();
		selectionSort.sort(array);
		System.out.println(Arrays.toString(array));
		
		SelectionSort randomArray = new SelectionSort();
		randomArray.displayTime(randomArray.generateRandomNumbers(100000, 100000));
		
	}
}
