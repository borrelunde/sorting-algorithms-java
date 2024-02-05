package com.borrelunde.sortingalgorithms.quicksort;

/**
 * Quicksort is a comparison-based sorting algorithm. It works by selecting a
 * 'pivot' element from the array and partitioning the other elements into two
 * sub-arrays according to whether they are less than or greater than the pivot.
 * The sub-arrays are then sorted recursively. This is done in-place, requiring
 * small additional amounts of memory to perform the sorting.
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.02.03
 */
public class Quicksort {

	public static void sort(int[] array) {
		// Start the recursive sorting process.
		quicksort(array, 0, array.length - 1);
	}

	private static void quicksort(int[] array, int low, int high) {

		// If the array has 0 or 1 elements, it is already sorted. Return and
		// stop the recursion.
		if (low >= high) {
			return;
		}

		// Partition the array and sort the sub-arrays.
		int partition = partition(array, low, high);
		quicksort(array, low, partition - 1);  // Sort the left sub-array.
		quicksort(array, partition + 1, high);  // Sort the right sub-array.
	}

	private static int partition(int[] array, int low, int high) {

		// Select the pivot as the last element in the array.
		int pivot = array[high];
		int left = low;  // Index of the leftmost element.
		int right = high;  // Index of the rightmost element.

		// Move elements smaller than the pivot to the left, and elements larger
		// than the pivot to the right.
		while (left < right) {
			// Find the first element from the left that is larger than the pivot,
			// and the first element from the right that is smaller than the pivot.
			while (array[left] <= pivot && left < right) {
				left++;
			}
			while (array[right] >= pivot && left < right) {
				right--;
			}
			// Swap these elements, so long as the left index is less than the
			// right index. This is to avoid swapping left and right when they
			// have crossed each other.
			if (left < right) {
				swap(array, left, right);
			}
		}
		// Move the pivot to the correct position. Similar to above, avoid
		// swapping if that would mean swapping the pivot with itself.
		if (left < high) {
			swap(array, left, high);
		}

		// Return the index of the pivot. It is in the correct position, and
		// the left and right sub-arrays can be sorted recursively from here.
		return left;
	}

	private static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
