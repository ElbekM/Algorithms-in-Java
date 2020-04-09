package Algorithms.SortingAlgorithms;

import java.util.Calendar;

/**
 * 
 * @author ElbekM
 */

public abstract class SortAlgorithm {

	public abstract int[] sort(int[] array);
	
	public int[] generateRandomNumbers(int size, int range) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			int number = (int) (Math.random() * range);
			array[i] = number;
		}
		return array;
	}
	
	public void displayTime(int[] array) {
		Long startTime = Calendar.getInstance().getTime().getTime();
		sort(array);
		Long endTime = Calendar.getInstance().getTime().getTime();
		System.out.println(String.format(
				"Sorting : %s items : %s seconds", array.length, (endTime - startTime) * 0.001));
	}
}
