package com.borrelunde.sortingalgorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * SortingAlgorithmTest is an interface all sorting algorithms should implement.
 * It contains standard sorting algorithm tests so that they don't have to be
 * rewritten for every algorithm.
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.02.02
 */
public interface SortingAlgorithmTest {

	void sort(int[] array);

	static Stream<Arguments> provideSingleElementArrays() {
		return Stream.of(
				Arguments.of(new int[]{Integer.MIN_VALUE}, new int[]{Integer.MIN_VALUE}),
				Arguments.of(new int[]{- 1}, new int[]{- 1}),
				Arguments.of(new int[]{0}, new int[]{0}),
				Arguments.of(new int[]{1}, new int[]{1}),
				Arguments.of(new int[]{Integer.MAX_VALUE}, new int[]{Integer.MAX_VALUE}));
	}

	static Stream<Arguments> provideUnsortedArrays() {
		return Stream.of(
				Arguments.of(new int[]{4, 2, 5, 1, 3}, new int[]{1, 2, 3, 4, 5}),
				Arguments.of(new int[]{10, 7, 8, 9, 1}, new int[]{1, 7, 8, 9, 10}),
				Arguments.of(new int[]{0, - 1, 1, - 2, 2}, new int[]{- 2, - 1, 0, 1, 2}),
				Arguments.of(new int[]{- 5, - 3, - 4, - 1, - 2}, new int[]{- 5, - 4, - 3, - 2, - 1}),
				Arguments.of(new int[]{20, 18, 22, 21, 19}, new int[]{18, 19, 20, 21, 22})
		);
	}

	static Stream<Arguments> provideReverseSortedArrays() {
		return Stream.of(
				Arguments.of(new int[]{5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5}),
				Arguments.of(new int[]{9, 8, 7, 6, 5}, new int[]{5, 6, 7, 8, 9}),
				Arguments.of(new int[]{- 1, - 2, - 3, - 4, - 5}, new int[]{- 5, - 4, - 3, - 2, - 1}),
				Arguments.of(new int[]{15, 14, 13, 12, 11}, new int[]{11, 12, 13, 14, 15}),
				Arguments.of(new int[]{0, - 1, - 2, - 3, - 4}, new int[]{- 4, - 3, - 2, - 1, 0})
		);
	}

	static Stream<Arguments> provideAlreadySortedArrays() {
		return Stream.of(
				Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}),
				Arguments.of(new int[]{6, 7, 8, 9, 10}, new int[]{6, 7, 8, 9, 10}),
				Arguments.of(new int[]{- 5, - 4, - 3, - 2, - 1}, new int[]{- 5, - 4, - 3, - 2, - 1}),
				Arguments.of(new int[]{11, 12, 13, 14, 15}, new int[]{11, 12, 13, 14, 15}),
				Arguments.of(new int[]{- 1, 0, 1, 2, 3}, new int[]{- 1, 0, 1, 2, 3})
		);
	}

	static Stream<Arguments> provideIdenticalElementArrays() {
		return Stream.of(
				Arguments.of(new int[]{2, 2, 2, 2, 2}, new int[]{2, 2, 2, 2, 2}),
				Arguments.of(new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0}),
				Arguments.of(new int[]{- 1, - 1, - 1, - 1, - 1}, new int[]{- 1, - 1, - 1, - 1, - 1}),
				Arguments.of(new int[]{5, 5, 5, 5, 5}, new int[]{5, 5, 5, 5, 5}),
				Arguments.of(new int[]{10, 10, 10, 10, 10}, new int[]{10, 10, 10, 10, 10})
		);
	}

	@Test
	@DisplayName("Sort an empty array")
	default void sortAnEmptyArray() {
		int[] numbers = {};
		int[] expected = {};
		sort(numbers);
		assertArrayEquals(expected, numbers);
	}

	@ParameterizedTest(name = "Sort single element array: {0}")
	@DisplayName("Sort single element arrays")
	@MethodSource("provideSingleElementArrays")
	default void sortSingleElementArrays(int[] numbers, int[] expected) {
		sort(numbers);
		assertArrayEquals(expected, numbers);
	}

	@ParameterizedTest(name = "Sort unsorted array: {0}")
	@DisplayName("Sort unsorted arrays")
	@MethodSource("provideUnsortedArrays")
	default void sortUnsortedArrays(int[] numbers, int[] expected) {
		sort(numbers);
		assertArrayEquals(expected, numbers);
	}

	@ParameterizedTest(name = "Sort reverse sorted array: {0}")
	@DisplayName("Sort reverse sorted arrays")
	@MethodSource("provideReverseSortedArrays")
	default void sortReverseSortedArrays(int[] numbers, int[] expected) {
		sort(numbers);
		assertArrayEquals(expected, numbers);
	}

	@ParameterizedTest(name = "Sort already sorted array: {0}")
	@DisplayName("Sort already sorted arrays")
	@MethodSource("provideAlreadySortedArrays")
	default void sortAlreadySortedArrays(int[] numbers, int[] expected) {
		sort(numbers);
		assertArrayEquals(expected, numbers);
	}

	@ParameterizedTest(name = "Sort identical element array: {0}")
	@DisplayName("Sort identical element arrays")
	@MethodSource("provideIdenticalElementArrays")
	default void sortIdenticalElementArrays(int[] numbers, int[] expected) {
		sort(numbers);
		assertArrayEquals(expected, numbers);
	}
}