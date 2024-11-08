package com.example.algorithm.apointer

import kotlin.math.abs

/**
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
 * The result should also be sorted in ascending order.
 *
 * An integer a is closer to x than an integer b if:
 *  |a - x| < |b - x|, or
 *  |a - x| == |b - x| and a < b
 *
 * Example 1:
 * Input: arr = [1,2,3,4,5], k = 4, x = 3
 * Output: [1,2,3,4]
 *
 * Example 2:
 * Input: arr = [1,2,3,4,5], k = 4, x = -1
 * Output: [1,2,3,4]
 */
class FindKClosestElements {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     */
    private fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        var right = arr.size - 1
        var left = 0
        while (right - left >= k) {
            if (abs(arr[left] - x) > abs(arr[right] - x)) {
                left++
            } else {
                right--
            }
        }

        val result = arrayListOf<Int>()
        while (left <= right) {
            result.add(arr[left])
            left++
        }

        return result
    }

    /**
     * Time Complexity: O(k * log(n))
     * Space Complexity: O(k)
     *
     * Use binary search to find cross-over position
     * Loop to left and right to get k closest elements
     */
}