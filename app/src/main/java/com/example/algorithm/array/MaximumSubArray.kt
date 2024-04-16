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
     * Kadane’s algorithm - Complexity O(n)
     */
    fun solution(input: List<Int>): Int {
        var maxSum = Int.MIN_VALUE
        var currentSum = 0
        input.forEach { element ->
            // Sum the sub-array to find the largest
            currentSum += element
            if (maxSum < currentSum) {
                maxSum = currentSum
            }
            // Reset when the sum is smaller than 0
            if (currentSum < 0) {
                currentSum = 0
            }
        }

        return maxSum
    }
}