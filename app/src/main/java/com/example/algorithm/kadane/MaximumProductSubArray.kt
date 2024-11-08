package com.example.algorithm.kadane

import kotlin.math.max
import kotlin.math.min

/**
 * Given an integer array nums, find a sub-array that has the largest product, and return the product.
 *
 * Example 1:
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2:
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a sub-array.
 *
 * [Medium] https://leetcode.com/problems/maximum-product-subarray/
 */
class MaximumProductSubArray {

    fun execute() {
        println(maxProduct(intArrayOf(2,3,-2,4)))
    }

    /**
     * Dry run
     * Begin
     * - maxEnding: 2, minEnding: 2, maxProduct: 2
     * Step 1
     * - element: 3, maxTemp: 6
     * - maxEnding: 6, minEnding: 3, maxProduct: 6
     * Step 2
     * - element: -2, maxTemp: -2
     * - minEnding: -12 => [2,3,-2]
     * - maxEnding: -2 => [-2]
     * - maxProduct: 6
     * Step 3
     * - element: 4, maxTemp: 4
     * - minEnding: -48 => [2,3,-2,4]
     * - maxEnding: 4
     * - maxProduct: 6
     */
    private fun maxProduct(arr: IntArray): Int {
        var maxEnding = arr[0]
        var minEnding = arr[0]
        var maxProduct = arr[0]

        for (i in 1 until arr.size) {
            val element = arr[i]
            val maxTemp = max(
                max(element, element * maxEnding),
                element * minEnding
            )
            minEnding = min(
                min(element, element * maxEnding),
                element * minEnding
            )
            maxEnding = maxTemp
            maxProduct = max(maxProduct, maxEnding)
        }

        return maxProduct
    }

    /**
     * Covered input [0, 10, 10, 10, 10, 10, 10, 10, 10, 10, -10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0]
     */
//    fun maxProduct(arr: IntArray): Int {
//        // max positive product
//        // ending at the current position
//        var maxEnding = arr[0].toLong()
//        // min negative product ending
//        // at the current position
//        var minEnding = arr[0].toLong()
//        // Initialize overall max product
//        var maxProduct = arr[0].toLong()
//
//        for (i in 1 until arr.size) {
//            val element = arr[i].toLong()
//            val maxTemp = max(
//                max(element, arr[i] * maxEnding),
//                arr[i] * minEnding
//            )
//            val minTemp = min(
//                min(element, arr[i] * maxEnding),
//                element * minEnding
//            )
//
//            maxEnding = maxTemp
//            if (minTemp < Int.MAX_VALUE && minTemp > Int.MIN_VALUE) {
//                minEnding = minTemp
//            }
//
//            maxProduct = max(maxProduct, maxEnding)
//        }
//
//        return maxProduct.toInt()
//    }
}