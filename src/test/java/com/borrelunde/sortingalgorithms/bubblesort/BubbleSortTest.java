package com.borrelunde.sortingalgorithms.bubblesort;

import com.borrelunde.sortingalgorithms.SortingAlgorithmTest;
import org.junit.jupiter.api.DisplayName;

/**
 * This is the test for the BubbleSort sorting algorithm.
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.02.02
 */
@DisplayName("Bubble Sort")
class BubbleSortTest implements SortingAlgorithmTest {

	@Override
	public void sort(final int[] array) {
		BubbleSort.sort(array);
	}
}