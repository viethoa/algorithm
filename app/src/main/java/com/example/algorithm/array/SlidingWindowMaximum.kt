package com.example.algorithm.array

import java.util.PriorityQueue

/**
 * Given an array and an integer K, find the maximum for each and every contiguous subarray of size K.
 *
 * Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
 * Output: 3 3 4 5 5 5 6
 * Explanation: Maximum of 1, 2, 3 is 3
 * Maximum of 2, 3, 1 is 3
 * Maximum of 3, 1, 4 is 4
 * Maximum of 1, 4, 5 is 5
 * Maximum of 4, 5, 2 is 5
 * Maximum of 5, 2, 3 is 5
 * Maximum of 2, 3, 6 is 6
 *
 * Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4
 * Output: 10 10 10 15 15 90 90
 * Explanation: Maximum of first 4 elements is 10, similarly for next 4
 * elements (i.e from index 1 to 4) is 10, So the sequence
 * generated is 10 10 10 15 15 90 90
 */
class SlidingWindowMaximum {

    /**
     * Solution 2: O(n)
     * Using Max-Heap data structure
     *  - It is a tree with the max value is root
     */
    fun maxHeapSolution(input: List<Int>, k: Int): List<Int> {
        if (input.isEmpty()) {
            return emptyList()
        }
        if (k == 1) {
            return input
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


    /**
     * Solution 1: O((n-k)*k)
     *  - K = 1 => O(n)
     *  - K = n => O(n)
     *  - k != n => O((n-k)*k)
     * 1. Loop array
     * 2. Loop K time to find max number
     */
    fun solution1(input: List<Int>, k: Int): List<Int> {
        if (input.isEmpty()) {
            return emptyList()
        }
        if (k == 1) {
            return input
        }

        val output = mutableListOf<Int>()
        for (i in 0..(input.size - k)) {
            findMax(input.subList(i, i + k))
                ?.let { max ->
                    output.add(max)
                }
        }

        return output
    }

    private fun findMax(input: List<Int>): Int? {
        if (input.isEmpty()) {
            return null
        }

        var max = Integer.MIN_VALUE
        input.forEach { element ->
            if (max < element) {
                max = element
            }
        }

        return max
    }
}