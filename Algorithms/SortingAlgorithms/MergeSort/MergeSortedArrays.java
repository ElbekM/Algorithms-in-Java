package Algorithms.SortingAlgorithms.MergeSort;

import java.util.Arrays;
import java.util.Calendar;

public class MergeSortedArrays {

	public int[] sort(int[] firstArr, int[] secondArr) {
		int total_len = firstArr.length + secondArr.length;
        int[] sortedArr = new int[total_len];
        int i = 0, j = 0;
        for (int index = 0; i + j < total_len; ++index) {
        	if (j == secondArr.length || i < firstArr.length && firstArr[i] <= secondArr[j]) {
        		sortedArr[index] = firstArr[i++];
        	} else {
        		sortedArr[index] = secondArr[j++];
        	}
        }
        return sortedArr;
	}
	
	/*
	public int[] generateRandomNumbers(int size, int range) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			int number = (int) (Math.random() * range);
			array[i] = number;
		}
		return array;
	}
	*/
	
	public void displayTime(int[] firstArr, int[] secondArr) {
		Long startTime = Calendar.getInstance().getTime().getTime();
		sort(firstArr, secondArr);
		Long endTime = Calendar.getInstance().getTime().getTime();
		System.out.println(String.format("Sorting : %s items : %s seconds", firstArr.length + secondArr.length, (endTime - startTime) * 0.001));
	}

	
	// Driver Program
	public static void main(String[] args) {
		int[] firstArr = {1, 3, 4, 7};
		int[] secondArr = {2, 5, 8, 9, 10};
		
		MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
		System.out.println(Arrays.toString(mergeSortedArrays.sort(firstArr, secondArr)));
		
		//MergeSortedArrays randomArray = new MergeSortedArrays();
		//randomArray.displayTime(randomArray.generateRandomNumbers(50000, 2000), );
	}
}
