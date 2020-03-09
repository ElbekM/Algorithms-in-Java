package Algorithms.SortingAlgorithms.SelectionSort;

import java.util.Arrays;

import Algorithms.SortingAlgorithms.SortAlgorithm;

/**
 * 
 * @author ElbekM
 */

public class SimpleSelectionSort extends SortAlgorithm {

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
		SimpleSelectionSort simpleSelectionSort = new SimpleSelectionSort();
		simpleSelectionSort.sort(array);
		System.out.println(Arrays.toString(array));
		
		SimpleSelectionSort randomArray = new SimpleSelectionSort();
		randomArray.displayTime(randomArray.generateRandomNumbers(100000, 100000));

	}
}
