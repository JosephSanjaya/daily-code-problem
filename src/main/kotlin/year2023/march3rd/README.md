We start by initializing the minimum broadcast range to 0. This variable will be updated as we find towers that can
cover listeners.

```kotlin
var minRange = 0
```

We iterate over the listeners in ascending order. We use the sorted function to sort the listeners before iterating over
them.
rust

```kotlin
listeners.sorted().forEach { listener ->
// ...
}
```

For each listener, we find the index of the closest tower using binary search. We use the binarySearch function to find
the index of the tower that is closest to the listener. If the listener's position exactly matches a tower's position,
then binarySearch returns its index. If not, it returns the bitwise complement of the index of the first tower whose
position is greater than the listener's position. We then use this index to compute the distances between the listener
and the two closest towers.

```kotlin

val towerIndex = towers.binarySearch(listener).let {
    if (it < 0) -(it + 1) else it
}
```

We compute the distances between the listener and the two closest towers. If the tower index is greater than 0, we
compute the distance to the left tower by subtracting the position of the tower to the left of the index from the
position of the listener. If the tower index is less than the number of towers, we compute the distance to the right
tower by subtracting the position of the tower to the right of the index from the position of the listener. We use
Int.MAX_VALUE as a sentinel value to indicate that a tower is not in range of a listener.

Notes:
> We use binary search in this solution to find the closest tower to each listener. Binary search is a good choice for this problem because the input data is sorted, which is a requirement for binary search. In general, binary search is a very efficient algorithm for searching for an element in a sorted array or list. It works by repeatedly dividing the search interval in half until the target element is found or determined to be not present. Binary search has a time complexity of O(log n), which is much faster than linear search, which has a time complexity of O(n). However, binary search requires the input data to be sorted in order to work correctly.

The best case for using binary search is when the input data is sorted, and the search interval can be divided in half repeatedly until the target element is found. This is because binary search has a time complexity of O(log n), which means that the number of comparisons required to find the target element grows very slowly as the size of the input data increases. In contrast, linear search has a time complexity of O(n), which means that the number of comparisons required to find the target element grows linearly with the size of the input data.

```kotlin
val leftDistance = if (towerIndex > 0) listener - towers[towerIndex - 1] else Int.MAX_VALUE
val rightDistance = if (towerIndex < towers.size) towers[towerIndex] - listener else Int.MAX_VALUE
```
We update the minimum broadcast range to be the maximum of the current minimum range and the minimum of the distances to
the two closest towers. This ensures that we cover all listeners.

```kotlin
minRange = maxOf(minRange, minOf(leftDistance, rightDistance))
```
Finally, we return the minimum broadcast range as the solution to the problem.
```kotlin
return minRange
```