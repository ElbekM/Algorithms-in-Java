package Algorithms.SortingAlgorithms;

/**
 * Quick Sort
 * 
 * Uses partitioning to recursively divide and sort the list
 * 
 * Time Complexity: O(N log N) | O(N**2) (worst case)
 * 
 * Space Complexity: O(1)
 * 
 * Stable: No
 */

//TODO optimize to pivot - 1 & pivot + 1, add insert sort to arrays < 10
public class QuickSort extends SortAlgorithm {

	@Override
	public int[] sort(int[] array) {
		reqQuickSort(array, 0, array.length - 1);
		return array;
	}

	private void reqQuickSort(int[] array, int left, int right) {
		if (left < right) {
			int pivot = partition(array, left, right);
			reqQuickSort(array, left, pivot - 1);
			reqQuickSort(array, pivot, right);
		}
	}

	private int partition(int[] array, int left, int right) {
		int pivot_index = left + (int) (Math.random() * (right - left + 1));
		int pivot_value = array[pivot_index];

		while (left <= right) {
			while (array[left] < pivot_value) {
				++left;
			}
			while (array[right] > pivot_value) {
				--right;
			}
			if (left <= right) {
				swap(array, left++, right--);
			}
		}
		return left;
	}

	// Driver Programm
	public static void main(String[] args) {

		int[] array = { 50, 7, 2, 4, 5, 10, 2, 1, 15, 30 };
		QuickSort quickSort = new QuickSort();
		quickSort.sort(array);
		quickSort.print(array);

		QuickSort randomArray = new QuickSort();
		randomArray.displayTime(randomArray.generateRandomNumbers(100000, 100000));
	}
}
