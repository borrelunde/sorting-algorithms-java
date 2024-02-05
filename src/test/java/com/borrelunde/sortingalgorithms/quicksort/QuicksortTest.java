package com.borrelunde.sortingalgorithms.quicksort;

import com.borrelunde.sortingalgorithms.SortingAlgorithmTest;
import org.junit.jupiter.api.DisplayName;

/**
 * This is the test for the quicksort sorting algorithm.
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.02.03
 */
@DisplayName("Quicksort")
class QuicksortTest implements SortingAlgorithmTest {

	@Override
	public void sort(final int[] array) {
		Quicksort.sort(array);
	}
}