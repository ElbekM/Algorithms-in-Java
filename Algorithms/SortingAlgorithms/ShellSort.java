package Algorithms.SortingAlgorithms;

/**
 * Shell sort a
 * 
 * @author Elbek M
 */

public class ShellSort extends SortAlgorithm {

	@Override
	public int[] sort(int[] array) {
		int h = 1;
		while (h < array.length) {
			h = (h + 1) * 3; 
		}
		
		for (int i = 0; i < array.length; ++i) {
			
		}
		
		return array;
	}

}
