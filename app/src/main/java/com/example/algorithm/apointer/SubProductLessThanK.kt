package com.example.algorithm.apointer

/**
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays
 * where the product of all the elements in the subarray is strictly less than k.
 *
 * Input: nums = [10,5,2,6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 *
 * Input: nums = [1,2,3], k = 0
 * Output: 0
 *
 * [Medium] https://leetcode.com/problems/subarray-product-less-than-k/
 */
class SubProductLessThanK {

    fun execute() {
        println(
            subArrayProductLessThanK2(
                intArrayOf(10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3), 19
            )
        )
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private fun subArrayProductLessThanK2(nums: IntArray, k: Int): Int {
        var product = 1
        var start = 0
        var count = 0

        for (i in nums.indices) {
            product *= nums[i]

            while (start <= i && product >= k) {
                product /= nums[start]
                start++
            }

            if (product < k) {
                count += i - start + 1
            }
        }

        return count
    }

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    private fun subArrayProductLessThanK(nums: IntArray, k: Int): Int {
        var product = 0
        for (i in 1..nums.size) {
            var subProduct = 1L
            for (j in 0 until i) {
                subProduct *= nums[j]
            }
            if (subProduct < k) {
                product++
            }

            for (z in i until nums.size) {
                subProduct = (subProduct * nums[z]) / nums[z - i]
                if (subProduct < k) {
                    product++
                }
            }
        }

        return product
    }
}