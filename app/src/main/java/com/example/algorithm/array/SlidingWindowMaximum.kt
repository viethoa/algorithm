package com.example.algorithm.array

import java.util.PriorityQueue

/**
 * Given an array and an integer K, find the maximum for each and every contiguous subarray of size K.
 *
 * Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
 * Output: 3 3 4 5 5 5 6
 * Explanation:
 * Maximum of 1, 2, 3 is 3
 * Maximum of 2, 3, 1 is 3
 * Maximum of 3, 1, 4 is 4
 * Maximum of 1, 4, 5 is 5
 * Maximum of 4, 5, 2 is 5
 * Maximum of 5, 2, 3 is 5
 * Maximum of 2, 3, 6 is 6
 *
 * Input: {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4
 * Output: 10 10 10 15 15 90 90
 *
 * Input: [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 */
class SlidingWindowMaximum {

    /**
     * Solution: O(n)
     * Input: [1, 2, 3, 1, 4, 5, 2, 3, 6]
     * 1. Find the first largest [1, 2, 3]
     *  - Output: [3]
     * 2. Second sub-array [2, 3, 1]
     *  - "1" is new element: 1 < 3 (current largest)
     *  - => Output: [3, 3]
     * 3. Third sub-array [3, 1, 4]
     *  - "4" is new element: 4 > 3 (current largest)
     *  - Update largest: 4
     *  - => Output: [3, 3, 4]
     *
     *  ....
     *
     *  Final output: [3, 3, 4, 5, 5, 5, 6]
     */
    fun solution(input: List<Int>, k: Int): List<Int> {
        var largest = Int.MIN_VALUE
        val output = arrayListOf<Int>()

        // Find first maximum
        for (i in 0 until k) {
            if (input[i] > largest) {
                largest = input[i]
            }
        }
        output.add(largest)

        // Find the rest
        for (i in k until input.size) {
            if (input[i] > largest) {
                largest = input[i]
            }
            output.add(largest)
        }

        return output
    }

    /**
     * Solution 2: O(n)
     * Using Max-Heap data structure
     *  - It is a tree with the max value is root
     */
    fun maxHeapSolution(input: List<Int>, k: Int): List<Int> {
        if (k >= input.size) {
            return emptyList()
        }

        val queue = PriorityQueue<Int>()
        for (i in 0 until k) {
            queue.offer(input[i])
        }

        val output = mutableListOf<Int>()
        // Add the max element of the first window
        queue.peek()?.let {
            output.add(it)
        }

        for (i in 1..(input.size - k)) {
            // Remove the first element if it is out of window
            if (queue.peek() == input[i - 1]) {
                queue.poll() /* remove head */
            }
            // Add next element into queue
            queue.offer(input[i + k - 1])
            // Add the max element
            queue.peek()?.let {
                output.add(it)
            }
        }

        return output
    }
}