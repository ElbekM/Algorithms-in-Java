package Algorithms.SortingAlgorithms.ExchangeSorting;

import java.util.Arrays;

import Algorithms.SortingAlgorithms.SortAlgorithm;

public class CombSort extends SortAlgorithm {
	
	@Override
	public int[] sort(int[] array) {
		final double FACTOR = 1.247330950103979;
	    int gap = array.length;
	    boolean swapped = true;
	    while (swapped) {
	    	if (gap > 1) {
	    		gap = (int)(gap / FACTOR);
	    	}
	        swapped = false;
	        for (int i = 0; i + gap < array.length; ++i) {
	        	if (array[i] > array[gap + i]) {
	        		int tmp = array[i];
	        		array[i] = array[gap + i];
	        		array[gap + 1] = tmp;
	        		swapped = true;
	        	}
	        }
	    }
	    System.out.println(Arrays.toString(array));
		return array;
	}

	// Driver Program
	public static void main(String[] args) {
			
		//int[] array = {5, 7, 2, 4, 5, 10};
		int[] a = {1, 2, 3};
		int[] array0 = {0};
		int[] array1 = {1, -1};
		int[] array2 = {};
		int[] array4 = {3, 2, 4, 5, 20, 13, 7, 1, -2, -10};
		int[] array5 = {5, 7, 2, 4, 3, 2, 4, 5, 20, 13, 7, 1, -2, -10, 5, 10};
		int[] array6 = {1, 3, 5, 7, 10};
		int[] array7 = {2, 4, 8, 12, 15};
		int[] array8 = {10, 9, 9, 9, 8, 7, 7, 5, 5, 3, 2, 2, 1, 1};
		int[] test = {5, 8, 1, 9, 2, 6, 3};
		
		CombSort combSort = new CombSort();
		combSort.sort(a);
		combSort.sort(array0);
		combSort.sort(array1);
		combSort.sort(array2);
		combSort.sort(array4);
		combSort.sort(array5);
		combSort.sort(array6);
		combSort.sort(array7);
		combSort.sort(array8);
		combSort.sort(test);
		//System.out.println(Arrays.toString(array));
			
		//CombSort randomArray = new CombSort();
		//randomArray.displayTime(randomArray.generateRandomNumbers(100000, 100000));
	}
}
