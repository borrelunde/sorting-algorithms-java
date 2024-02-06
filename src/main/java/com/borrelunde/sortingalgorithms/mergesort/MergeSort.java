package com.borrelunde.sortingalgorithms.mergesort;

/**
 * Merge sort is a comparison-based sorting algorithm. It recursively divides
 * the array into two halves, sorts each half, and then merges them into a
 * single sorted array.
 * <p>
 * It is a divide-and-conquer algorithm, and is generally considered to be one
 * of the most efficient sorting algorithms out there.
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.02.06
 */
public class MergeSort {

	public static void sort(int[] array) {
		// Start the recursive sorting process.
		mergeSort(array, 0, array.length - 1);
	}

	private static void mergeSort(int[] array, int low, int high) {
		// If the array has 0 or 1 elements, it's already sorted.
		if (low >= high) {
			return;
		}
		// Calculate the middle index of the array. Bitwise shift to the right
		// is the same as dividing by 2, but faster.
		int middle = low + ((high - low) >> 1);
		mergeSort(array, low, middle);  // Sort the left half.
		mergeSort(array, middle + 1, high);  // Sort the right half.
		merge(array, low, middle, high);  // Merge the two sorted halves.
	}

	private static void merge(int[] array, int low, int middle, int high) {

		// Temporary arrays for the left and right sub-arrays.
		int[] leftArray = new int[middle - low + 1];
		int[] rightArray = new int[high - middle];

		// Copy the elements of the array into the left and right sub-arrays.
		copyArray(array, leftArray, low, middle);
		copyArray(array, rightArray, middle + 1, high);

		// Indices for left and right sub-arrays, and the merged array.
		int left = 0;
		int right = 0;
		int i = low;

		// Merge left and right sub-arrays into the original array.
		while (left < leftArray.length && right < rightArray.length) {
			if (leftArray[left] <= rightArray[right]) {
				array[i++] = leftArray[left++];
			} else {
				array[i++] = rightArray[right++];
			}
		}

		// If there are remaining elements in the left sub-array, copy them into
		// the original array.
		while (left < leftArray.length) {
			array[i++] = leftArray[left++];
		}

		// The same goes for the right sub-array.
		while (right < rightArray.length) {
			array[i++] = rightArray[right++];
		}
	}

	private static void copyArray(int[] from, int[] to, int start, int end) {
		int i = 0;
		for (int j = start; j <= end; j++) {
			to[i++] = from[j];
		}
	}
}
