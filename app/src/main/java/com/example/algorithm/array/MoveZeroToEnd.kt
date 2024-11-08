package com.example.algorithm.array

/**
 * Given an unsorted array of integers, you have to move the array elements
 * in a way such that all the zeroes are transferred to the end,
 * and all the non-zero elements are moved to the front.
 * The non-zero elements must be ordered in their order of appearance.
 * Expected Complexity: O(n) time complexity and O(1) space complexity.
 *
 * Example
 * Input: [0, 1, -2, 3, 4, 0, 0, 5, -27, 9, 0],
 * Output: [1, -2, 3, 4, 5, -27, 9, 0, 0, 0, 0].
 *
 * Input: [0, 0, 0, 0, 0, 1],
 * Output: [1, 0, 0, 0, 0, 0].
 *
 * Input: [0, 0, 0, 0, 0, 0],
 * Output: [0, 0, 0, 0, 0, 0].
 */
class MoveZeroToEnd {

    fun execute() {
        val input = intArrayOf(0, 1, -2, 3, 4, 0, 5, -27, 9, 0)
        moveZeroToEnd(input)
        println(input.toList())
    }

    private fun moveZeroToEnd(input: IntArray) {
        // Move all non-zero elements to the front
        var j = 0
        for (i in input.indices) {
            if (input[i] != 0) {
                input[j] = input[i]
                j += 1
            }
        }

        // Set zero element at bottom
        for (i in j until input.size) {
            input[i] = 0
        }
    }
}