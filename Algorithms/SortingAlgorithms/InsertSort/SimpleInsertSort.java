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
		int index;
		for (int element = 0; element < array.length; ++element) {
			int tmp = array[element];
			for (index = element - 1; index >= 0 && tmp < array[index]; index--) {
				array[index + 1] = array[index];
			}
			array[index + 1] = tmp;
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
