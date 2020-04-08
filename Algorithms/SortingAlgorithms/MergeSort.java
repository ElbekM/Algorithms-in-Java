package Algorithms.SortingAlgorithms;

import java.util.Arrays;

/**
 * Merge Sort
 * 
 * Uses divide and conquer to recursively divide and sort the list Time
 * 
 * Complexity: O(N logN)
 * 
 * Space Complexity: O(N)
 * 
 * Auxiliary Stable: Yes
 * 
 * @author Elbek M
 */

public class MergeSort extends SortAlgorithm {

	@Override
	public int[] sort(int[] array) {
		mergeSort(array, 0, array.length - 1);
		return array;
	}

	private void mergeSort(int[] array, int left, int right) {
		if (left != right) {
			int middle = left + (right - left) / 2;
			mergeSort(array, left, middle);
			mergeSort(array, middle + 1, right);
			merge(array, left, middle, right);
		}
	}

	private void merge(int[] array, int left, int mid, int right) {
		int total_len = right - left + 1;
		int[] sortedArr = new int[total_len];
		int i = left;
		int j = mid + 1;
		for (int index = 0; i + j <= mid + right + 1; ++index) {
			if (j == right + 1 || (i <= mid && array[i] <= array[j])) {
				sortedArr[index] = array[i++];
			} else {
				sortedArr[index] = array[j++];
			}
		}
		System.arraycopy(sortedArr, 0, array, left, total_len);
	}
	

	// Driver Program
	public static void main(String[] args) {
		int[] array = { 3, 2, 3, 5, 10, 8, -5, 5 };
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(array);
		System.out.println(Arrays.toString(array));

		MergeSort randomArray = new MergeSort();
		randomArray.displayTime(randomArray.generateRandomNumbers(100000, 1000000));
	}
}
