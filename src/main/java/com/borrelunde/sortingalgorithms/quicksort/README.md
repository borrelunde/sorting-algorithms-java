## Overview

Quicksort is a divide-and-conquer sorting algorithm that works by selecting a pivot element from the array and
partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot.
The sub-arrays are then recursively sorted.

## Characteristics

- **Efficient for large datasets.**
- **Not stable**: Does not maintain the relative order of equal elements.
- **In-place sort**: Requires only a constant amount of additional space.
- **Suitable for**: Large datasets.

## Algorithm Complexity

### Time Complexity

The time complexity of quicksort varies based on the input array's initial order and the choice of pivot:

| Case      | Complexity |
|-----------|------------|
| Best      | O(n log n) |
| Average   | O(n log n) |
| Worst     | O(n^2)     |

- **Best case**: The pivot always divides the array into two nearly equal pieces.
- **Average case**: The pivot is randomly chosen, expected to achieve nearly equal division.
- **Worst case**: The smallest or largest element is always chosen as the pivot.

### Space Complexity

The space complexity of quicksort is logarithmic:

| Complexity |
|------------|
| O(log n)   |

This is because quicksort is a recursive algorithm, and it needs to store the intermediate state in the call stack.

## How It Works

Quicksort begins by partitioning the array - selecting one element (the pivot) and moving all elements less than the
pivot before it, and all elements greater than it after. The pivot is now in its final position. The algorithm then
recursively applies the same process to the sub-arrays formed by the elements before and after the pivot.

## Concepts

### Partitioning

```java
private static int partition(int[] array, int low, int high){
    int pivot = array[high];
    int left = low;
    int right = high;
    while (left < right) {
        while (array[left] <= pivot && left < right) {
            left++;
        }
        while (array[right] >= pivot && left < right) {
            right--;
        }
        if (left < right) {
            swap(array, left, right);
        }
    }
    if (left < high) {
        swap(array, left, high);
    }
    return left;
}
```

The partition method takes the last element as pivot, places the pivot element at its correct position in the sorted
array, and places all smaller elements to the left of the pivot and all greater elements to the right of the pivot.

### Swapping

```java
private static void swap(int[] array, int a, int b){
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
}
```

`temp` temporarily stores a value so that we can swap `array[a]` and `array[b]` without losing any data.

# Example

```text
Initial array: (4, 2, 5, 1, 3)

Pivot is chosen to be the last number in the array: 3

Partition array: (4, 2, 5, 1, 3)
│ (L)4, 2, 5, 1, (R)(P)3 |       | Initial array
│ (L)4, 2, 5, 1, (R)(P)3 | 4 < 3 | L stopped
│ (L)4, 2, 5, (R)1, (P)3 | 3 = 3 | R moved left
│ (L)4, 2, 5, (R)1, (P)3 | 1 < 3 | R stopped
│ (L)1, 2, 5, (R)4, (P)3 |       | Swapped L (4) and R (1)
│ 1, (L)2, 5, (R)4, (P)3 | 1 < 3 | L moved right
│ 1, 2, (L)5, (R)4, (P)3 | 2 < 3 | L moved right
│ 1, 2, (L)5, (R)4, (P)3 | 5 > 3 | L stopped
│ 1, 2, (L)(R)5, 4, (P)3 | 4 > 3 | R moved left
│ 1, 2, (L)(R)5, 4, (P)3 | L = R | R stopped
│ 1, 2, (L)(R)3, 4, (P)5 |       | Swapped L (5) and P (3)
│
├─── Left sub-array
│    │ Partition array: (1, 2)
│    │ (L)1, (R)(P)2 |       | Initial array
│    │ 1, (L)(R)(P)2 | 1 < 2 | L moved right
│    │ 1, (L)(R)(P)2 | L = R | L stopped
│    │ 1, (L)(R)(P)2 | L = R | R stopped
│    │
│    ├─── Left sub-array:
│    │    There is one element (1) in this sub-array: consider this side sorted.
│    │
│    └─── Right sub-array:
│         There is no element in this sub-array: consider this side sorted.
│
└─── Right sub-array: 
     │ Partition array: (4, 5)
     │ (L)4, (R)(P)5 |       | Initial array
     │ 4, (L)(R)(P)5 | 4 < 5 | L moved right
     │ 4, (L)(R)(P)5 | L = R | L stopped
     │ 4, (L)(R)(P)5 | L = R | R stopped
     │
     ├─── Left sub-array:
     │    There is one element (4) in this sub-array: consider this side sorted.
     │
     └─── Right sub-array:
          There is no element in this sub-array: consider this side sorted.

Final array: (1, 2, 3, 4, 5)
```

## Conclusion

While quicksort is not a stable sorting algorithm, its efficiency for large datasets due to its logarithmic time
complexity makes it a valuable tool for sorting large amounts of data.