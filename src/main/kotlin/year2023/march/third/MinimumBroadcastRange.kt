package year2023.march.third

/**
 * Problem
 *
 * This problem was asked by Spotify.
 *
 * You are the technical director of WSPT radio, serving listeners nationwide. For simplicity's sake we can consider each listener to live along a horizontal line stretching from 0 (west) to 1000 (east).
 * Given a list of N listeners, and a list of M radio towers, each placed at various locations along this line, determine what the minimum broadcast range would have to be in order for each listener's home to be covered.
 * For example, suppose listeners = [1, 5, 11, 20], and towers = [4, 8, 15]. In this case the minimum range would be 5, since that would be required for the tower at position 15 to reach the listener at position 20.
 */
fun main(args: Array<String>) {
    val listeners = listOf(1, 5, 11, 20)
    val towers = listOf(4, 8, 15)
    val minRange = minimumBroadcastRange(listeners, towers)
    println(minRange)
}

/**
 * Computes the minimum broadcast range required to cover all listeners given their positions
 * and the positions of radio towers.
 *
 * @param listeners A list of positions of listeners. Each position must be between 0 and 1000.
 * @param towers A list of positions of radio towers. Each position must be between 0 and 1000.
 * @return The minimum broadcast range required to cover all listeners.
 */
fun minimumBroadcastRange(listeners: List<Int>, towers: List<Int>): Int {
    var minRange = 0

    // Iterate over the listeners in ascending order
    listeners.sorted().forEach { listener ->
        // Find the index of the closest tower using binary search
        val towerIndex = towers.binarySearch(listener).let {
            if (it < 0) -(it + 1) else it
        }

        // Compute the distances between the listener and the two closest towers
        val leftDistance = if (towerIndex > 0) listener - towers[towerIndex - 1] else Int.MAX_VALUE
        val rightDistance = if (towerIndex < towers.size) towers[towerIndex] - listener else Int.MAX_VALUE

        // Update the minimum broadcast range
        minRange = maxOf(minRange, minOf(leftDistance, rightDistance))
    }

    return minRange
}