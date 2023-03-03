package year2023.march4th

/**
 * Problem
 *
 * This problem was asked by Apple.
 * A fixed point in an array is an element whose value is equal to its index.
 * Given a sorted array of distinct elements, return a fixed point, if one exists. Otherwise, return False.
 * For example, given [-6, 0, 2, 40], you should return 2. Given [1, 5, 7, 8], you should return False.
 */
fun main(args: Array<String>) {
    val arr1 = intArrayOf(-6, 0, 2, 40)
    val arr2 = intArrayOf(1, 5, 7, 8)
    println(findFixedPoint(arr1))  // output: 2
    println(findFixedPoint(arr2))  // output: false
}

/**
 * Finds the first fixed point in a sorted array of distinct integers, if one exists.
 * A fixed point is an element whose value is equal to its index in the array.
 *
 * @param arr the sorted array of distinct integers to search for a fixed point in
 * @return the index of the first fixed point found, or `false` if no fixed point exists in the array
 */
fun findFixedPoint(arr: IntArray): Any {
    var low = 0  // initialize the lower bound of the search range to the first index of the array
    var high = arr.size - 1  // initialize the upper bound of the search range to the last index of the array
    while (low <= high) {
        // continue searching while the search range is nonempty
        val mid = (low + high) / 2  // calculate the middle index of the search range

        when {
            arr[mid] == mid -> return mid  // if the middle element is a fixed point, return its index
            // if the middle element is less than its index, search the right half of the array
            arr[mid] < mid -> low = mid + 1
            // if the middle element is greater than its index, search the left half of the array
            else -> high = mid - 1
        }
    }

    return false  // if no fixed point was found, return `false`
}
