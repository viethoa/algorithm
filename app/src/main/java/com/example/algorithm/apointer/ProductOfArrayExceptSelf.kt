package com.example.algorithm.apointer

/**
 * Given an array arr[] of n integers, construct a Product Array prod[] (of the same size)
 * such that prod[i] is equal to the product of all the elements of arr[] except arr[i].
 * Note: Solve it without the division operator in O(n) time.
 *
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Example
 * Input: {10, 3, 5, 6, 2}
 * Output: {180, 600, 360, 300, 900}
 * - 180 = 3 * 5 * 6 * 2 (except 10)
 * - 600 = 10 * 5 * 6 * 2 (except 3)
 * - 360 = 10 * 3 * 6 * 2 (except 5)
 * - 300 = 10 * 3 * 5 * 2 (except 6)
 * - 900 = 10 * 3 * 6 * 5 (except 2)
 *
 * Input: {1, 2, 3, 4, 5}
 * Output: {120, 60, 40, 30, 24}
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 */
class ProductOfArrayExceptSelf {

    fun execute() {
        println(productExceptSelf(intArrayOf(1, 2, 3, 4, 5)).toList())
        println(productExceptSelf(intArrayOf(-1, 1, 0, -3, 3)).toList())
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * Dry run:
     * Step 1: [1, 1, 2, 6, 24]
     * Step 2: [120 ,60 ,40 ,30, 24]
     */
    private fun productExceptSelf(input: IntArray): IntArray {
        val result = IntArray(input.size)

        // Calculate left product
        var left = 1
        for (i in input.indices) {
            result[i] = left
            left *= input[i]
        }

        // Calculate right product
        var right = 1
        for (i in (input.size - 1) downTo 0) {
            result[i] *= right
            right *= input[i]
        }

        return result
    }
}