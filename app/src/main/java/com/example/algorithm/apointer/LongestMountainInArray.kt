package com.example.algorithm.apointer

/**
 * You may recall that an array arr is a mountain array if and only if:
 *  - arr.length >= 3
 *  - There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
 *      - arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 *      - arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 *
 * Given an integer array arr, return the length of the longest subarray, which is a mountain.
 * Return 0 if there is no mountain subarray.
 *
 * Input: arr = [2,1,4,7,3,2,5]
 * Output: 5
 * Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
 *
 * Input: arr = [2,2,2]
 * Output: 0
 * Explanation: There is no mountain.
 *
 * Input: [0,1,2,3,4,5,4,3,2,1,0]
 *
 * [Medium] https://leetcode.com/problems/longest-mountain-in-array/description/
 */
class LongestMountainInArray {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private fun longestMountain(arr: IntArray): Int {
        if (arr.size < 3) {
            return 0
        }

        var i = 1
        var longestMountain = 0
        while (i < arr.size - 1) {
            // Find the peak
            if (!(arr[i] > arr[i - 1] && arr[i] > arr[i + 1])) {
                i++
                continue
            }

            var j = i
            var count = 1 /* Count the Peak */
            // Count left side
            while (j > 0 && arr[j] > arr[j - 1]) {
                count++
                j--
            }
            // Count right side
            while (i < arr.size - 1 && arr[i] > arr[i + 1]) {
                count++
                i++
            }

            if (count > longestMountain) {
                longestMountain = count
            }
        }

        return longestMountain
    }
}