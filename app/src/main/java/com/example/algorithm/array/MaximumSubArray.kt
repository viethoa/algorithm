package com.example.algorithm.array

/**
 * Given an integer array nums, find the sub-array with the largest sum, and return its sum.
 *
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 *
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 *
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 */
class MaximumSubArray {

    /**
     * Complexity O(n)
     */
    fun solution(input: List<Int>): Int {
        var largestSum = Int.MIN_VALUE
        var sum = 0
        input.forEach { element ->
            // Sum the sub-array to find the largest
            sum += element
            // Track largest
            if (largestSum < sum) {
                largestSum = sum
            }
            // Reset when the sum is smaller than 0
            if (sum < 0) {
                sum = 0
            }
        }

        return largestSum
    }

    /**
     * Complexity O(n^2)
     */
    fun solution2(input: List<Int>): Int {
        if (input.isEmpty()) {
            return 0
        }
        if (input.size == 1) {
            return input[0]
        }

        var result = input.reduce { acc, next -> acc + next }
        for (i in 0 until input.size - 1) {
            for (j in i + 1 until input.size) {
                val sumOfSubArray = input.subList(i, j).reduce { acc, next -> acc + next }
                if (sumOfSubArray > result) {
                    result = sumOfSubArray
                }
            }
        }

        return result
    }
}