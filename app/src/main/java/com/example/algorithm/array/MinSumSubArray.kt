package com.example.algorithm.array

/**
 * Given an array of integers and a number k, find the minimum sum of a subarray of size k.
 *
 * Input: {100, 200, 300, 400},  k = 2
 * Output: 300
 *
 * Input: {1, 4, 2, 10, 23, 3, 1, 0, 20}, k = 4
 * Output: 17
 */
class MinSumSubArray {

    fun execute() {
        println(
            findMinSumSubArray(
                listOf(10, 4, 2, 5, 6, 3, 8, 1),
                3
            )
        )
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    private fun findMinSumSubArray(input: List<Int>, k: Int): Int {
        // First sub-array
        var minSum = 0
        for (i in 0 until k) {
            minSum += input[i]
        }

        // Calculate from next one
        var sumSubArray = minSum
        for (i in k until input.size) {
            sumSubArray = ((sumSubArray + input[i]) - input[i - k])
            if (sumSubArray < minSum) {
                minSum = sumSubArray
            }
        }

        return minSum
    }
}