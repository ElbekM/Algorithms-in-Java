package Algorithms.SortingAlgorithms.ExchangeSorting;

import java.util.Arrays;

import Algorithms.SortingAlgorithms.SortAlgorithm;

/**
 * 
 * @author ElbekM
 */

public class BubbleSort extends SortAlgorithm {

	@Override
	public int[] sort(int[] array) {
		for (int end = array.length - 1; end > 0; end--) {
			for (int j = 0; j < end; ++j) {
				if (array[j] > array[j + 1]) {
					int tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
		}
		return array;
	}
	
	
	// Driver Program
	public static void main(String[] args) {
		
		int[] array = {5, 7, 2, 4, 5, 10};
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort(array);
		System.out.println(Arrays.toString(array));
		
		BubbleSort randomArray = new BubbleSort();
		randomArray.displayTime(randomArray.generateRandomNumbers(100000, 100000));
	}
}
