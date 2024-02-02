# Bubble Sort

## Overview

Bubble sort is one of the simplest sorting algorithms that works by repeatedly swapping the adjacent elements if they
are in the wrong order. This process repeats from the beginning of the array until no swaps are needed, indicating that
the array is sorted.

## Characteristics

- **Simple to understand and implement.**
- **Stable sort**: Maintains the relative order of equal elements.
- **In-place sort**: Requires only a constant amount of additional space.
- **Suitable for**: Small datasets or datasets that are nearly sorted.

## Algorithm Complexity

### Time Complexity

The time complexity of bubble sort varies based on the input array's initial order:

| Case      | Complexity |
|-----------|------------|
| Best      | O(n)       |
| Average   | O(n^2)     |
| Worst     | O(n^2)     |

- **Best case**: The array is already sorted, requiring only one pass with no swaps.
- **Average case**: The array is in random order, requiring a quadratic number of comparisons and swaps.
- **Worst case**: The array is in reverse order, requiring the maximum number of swaps and comparisons.

### Space Complexity

The space complexity of bubble sort is constant, as it requires a fixed amount of space regardless of the input size:

| Complexity |
|------------|
| O(1)       |

This is because bubble sort is an in-place sorting algorithm, only requiring additional space for temporary variables
used during swapping.

## How It Works

Bubble sort compares each pair of adjacent items and swaps them if they are in the wrong order. This pass through the
array is repeated until the array is sorted. During each iteration, the largest unsorted element "bubbles up" to its
correct position at the end of the array.

## Concepts

### Reducing Comparisons

```java
for (int j = 1; j < array.length - i; j++) {
    // Code omitted.	
}
```

The `j < array.length - i` condition in the loop ensures that the algorithm does not re-compare elements that have already
been placed in their correct position in previous passes. With each iteration of the outer loop (`i` increasing), one
less element needs to be compared, thereby reducing the total number of comparisons and optimizing the sorting process.

### Swapping

```java
int temp = array[j - 1];
array[j - 1] = array[j];
array[j] = temp;
```

`temp` temporarily stores a value so that we can swap `array[j - 1]` and `array[j]` without losing any data.

### Early exit

```java
if (! swapped) {
    break;
}
```

If no swaps occur during a complete pass (indicating the array is sorted), the algorithm exits early to save unnecessary
iterations, enhancing the efficiency.

## Example

Let's sort the array `( 5 1 4 2 8 )`.  
In each step, elements written in bold are being compared. Three passes are required:

**First Pass**

> ( **5 1** 4 2 8 ) → ( **1 5** 4 2 8 ), swap since 5 > 1  
> ( 1 **5 4** 2 8 ) → ( 1 **4 5** 2 8 ), swap since 5 > 4  
> ( 1 4 **5 2** 8 ) → ( 1 4 **2 5** 8 ), swap since 5 > 2  
> ( 1 4 2 **5 8** ) → ( 1 4 2 **5 8** ), do not swap since 5 < 8

**Second Pass**

> ( **1 4** 2 5 8 ) → ( **1 4** 2 5 8 ), do not swap since 1 < 4  
> ( 1 **4 2** 5 8 ) → ( 1 **2 4** 5 8 ), swap since 4 > 2  
> ( 1 2 **4 5** 8 ) → ( 1 2 **4 5** 8 ), do not swap since 4 < 5
>
> 8 is in the correct place. With optimisation, that step is ignored.

The array is sorted, but the algorithm doesn't know it yet. It needs one more pass without any swap to know.

**Third Pass**

> ( **1 2** 4 5 8 ) → ( **1 2** 4 5 8 ), do not swap since 1 < 2  
> ( 1 **2 4** 5 8 ) → ( 1 **2 4** 5 8 ), do not swap since 2 < 4
>
> 5 is in the correct place. With optimisation, that step is ignored.  
> 8 is in the correct place. With optimisation, that step is ignored.

No swap took place, the sorting is complete.

## Conclusion

While bubble sort is not the most efficient sorting algorithm for large datasets due to its quadratic time complexity,
its simplicity and the concept of in-place sorting make it a valuable educational tool for understanding the basics of
sorting algorithms.