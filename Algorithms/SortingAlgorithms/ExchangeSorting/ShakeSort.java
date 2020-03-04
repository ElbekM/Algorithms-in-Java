package Algorithms.SortingAlgorithms.ExchangeSorting;

import java.util.Arrays;

import Algorithms.SortingAlgorithms.SortAlgorithm;

/**
 * 
 * @author ElbekM
 */

public class ShakeSort extends SortAlgorithm {

	@Override
	public int[] sort(int[] array) {
		int left = 0, right = array.length - 1;
		
		while (left <= right) {
			for (int i = left; i < right; ++i) {
				if (array[i] > array[i + 1]) {
					int tmp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = tmp;
				}
			}
			right--;
			
			for (int j = right; j > left; j--) {
				if (array[j] < array[j - 1]) {
					int tmp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = tmp;
				}
			}
			left++;
		}
		return array;
	}
	
	
	// Driver Program
	public static void main(String[] args) {
			
		int[] array = {5, 7, 2, 4, 5, 10};
		ShakeSort shakeSort = new ShakeSort();
		shakeSort.sort(array);
		System.out.println(Arrays.toString(array));
			
		ShakeSort randomArray = new ShakeSort();
		randomArray.displayTime(randomArray.generateRandomNumbers(50000, 2000));
	}	
}
