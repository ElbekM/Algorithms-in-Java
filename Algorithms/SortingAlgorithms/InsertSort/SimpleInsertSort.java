package Algorithms.SortingAlgorithms.InsertSort;

import java.util.Arrays;

import Algorithms.SortingAlgorithms.SortAlgorithm;

/**
 * 
 * @author ElbekM
 */

public class SimpleInsertSort extends SortAlgorithm {

	@Override
	public int[] sort(int[] array) {
		int index, value;
		
        for (int element = 1; element < array.length; ++element) {
        	value = array[element];
        	index = element;
        	while (index > 0 && array[index - 1] > value) {
        		array[index] = array[index - 1];
        		index--;
        	}
        	array[index] = value;
        }
		return array;
	}
	
	public int[] sortWithFor(int[] array) {
		int ind;
        for (int el = 0; el < array.length; ++el) {
        	int tmp = array[el];
        	for (ind = el - 1; ind >= 0 && tmp < array[ind]; ind--) {
        		array[ind + 1] = array[ind];
        	}
        	array[ind + 1] = tmp;
        }
        return array;
	}
	
	
	//Driver Programm
	public static void main(String[] args) {
		
		int[] array = {5, 7, 2, 4, 5, 10};
		SimpleInsertSort simpleInsertSort = new SimpleInsertSort();
		simpleInsertSort.sort(array);
		System.out.println(Arrays.toString(array));
		
		SimpleInsertSort randomArray = new SimpleInsertSort();
		randomArray.displayTime(randomArray.generateRandomNumbers(100000, 100000));
	}
}
