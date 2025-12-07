package com.example.algorithm.apointer

import kotlin.math.abs

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums
 * such that the sum is closest to target. Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * - https://leetcode.com/problems/3sum-closest/description/
 *
 * Example 1:
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Example 2:
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 */
class ThreeSumClosest {

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    private fun threeSumCloset(input: List<Int>, target: Int): Int {
        val n = input.size
        var closetSum = Integer.MAX_VALUE
        val sortedInput = input.sorted()

        for (i in 0 until n - 2) {
            var left = i + 1
            var right = n - 1
            while (left < right) {
                val sum = sortedInput[i] + sortedInput[left] + sortedInput[right]
                if (abs(target - sum) < abs(target - closetSum)) {
                    closetSum = sum
                }

                if (sum > target) {
                    right -= 1
                } else {
                    left += 1
                }
            }
        }

        return closetSum
    }
}