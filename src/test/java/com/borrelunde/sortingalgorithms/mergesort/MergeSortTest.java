package com.borrelunde.sortingalgorithms.mergesort;

import com.borrelunde.sortingalgorithms.SortingAlgorithmTest;

/**
 * This is the test for the merge sort sorting algorithm.
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.02.06
 */
class MergeSortTest implements SortingAlgorithmTest {

	@Override
	public void sort(final int[] array) {
		MergeSort.sort(array);
	}
}
