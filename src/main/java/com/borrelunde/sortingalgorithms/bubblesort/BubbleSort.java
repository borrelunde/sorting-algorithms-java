package com.borrelunde.sortingalgorithms.bubblesort;

/**
 * Bubble sort is a simple comparison-based sorting algorithm. It works by
 * repeatedly stepping through the list to be sorted, comparing each pair of
 * adjacent items and swapping them if they are in the wrong order. The pass
 * through the list is repeated until no swaps are needed, which means the list
 * is sorted.
 * <p>
 * The algorithm gets its name because smaller elements "bubble" to the top of
 * the list (beginning of the array) with each iteration, while larger elements
 * sink to the bottom (end of the array).
 * <p>
 * Although the algorithm is simple and intuitive, it is not suitable for large
 * datasets as its average and worst-case complexity is O(n^2), where n is the
 * number of items being sorted.
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.02.02
 */
public class BubbleSort {

	public static void sort(int[] array) {
		boolean swapped;
		for (int i = 0; i < array.length; i++) {
			swapped = false;
			for (int j = 1; j < array.length - i; j++) {
				if (array[j - 1] > array[j]) {
					// Swap previous and current value.
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
					swapped = true;
				}
			}
			// Exit early if no swap took place.
			if (! swapped) {
				break;
			}
		}
	}
}