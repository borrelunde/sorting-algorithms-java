## Overview

Merge Sort is a divide-and-conquer sorting algorithm that works by recursively dividing the array into two halves, sorting each half, and then merging the sorted halves into a single sorted array.

## Characteristics

- **Efficient for large datasets.**
- **Stable**: Maintains the relative order of equal elements.
- **Out-of-place sort**: Requires additional space proportional to the size of the input.
- **Suitable for**: Large datasets, when stability is required.

## Algorithm Complexity

### Time Complexity

The time complexity is logarithmic for all cases:

| Case      | Complexity |
|-----------|------------|
| Best      | O(n log n) |
| Average   | O(n log n) |
| Worst     | O(n log n) |

- **Best case**: The array is already sorted.
- **Average case**: The array is randomly distributed.
- **Worst case**: The array is sorted in reverse order.

### Space Complexity

The space complexity is linear:

| Complexity |
|------------|
| O(n)       |

This is because it is a recursive algorithm, and it needs to store the intermediate state in the call stack.

## How It Works

Merge sort begins by dividing the array into two halves. These halves are then recursively sorted and merged. The merging process involves comparing the elements of the two halves and adding the smaller one to the sorted array until both halves are fully merged.

## Concepts

### Merging

```java
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
```

The merge method merges two sorted sub-arrays into a single sorted array. It creates temporary arrays for the left and right sub-arrays, then merges the elements from the left and right sub-arrays into the original array.

## Example

```text
Initial array: (4, 2, 5, 1, 3)

Divide array: (4, 2, 5, 1, 3)
│ (4, 2), (5, 1, 3)       | Divide into two halves
│ (4), (2), (5, 1, 3)     | Divide into two halves
│ (4), (2), (5), (1, 3)   | Divide into two halves
│ (4), (2), (5), (1), (3) | Divide into two halves
│
├─── Merge sub-arrays
│    │ (4), (2)           | Merge into (2, 4)
│    │ (5), (1, 3)        | Merge into (1, 3, 5)
│    │ (2, 4), (1, 3, 5)  | Merge into (1, 2, 3, 4, 5)
│
└─── Final array: (1, 2, 3, 4, 5)
```

## Conclusion

While merge sort requires additional space proportional to its input, its efficiency for large datasets due to its logarithmic time complexity makes it a great algorithm for sorting large amounts of data. Moreover, it is a stable algorithm, which can be important in certain cases.