package com.example.algorithm.apointer

import kotlin.math.max
import kotlin.math.min

/**
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 *
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The max area of water is [8,6,2,5,4,8,3,7]
 * - Size from 8 -> 7 = 7
 * - Min height = 7
 * => max area of water = 7 * 7 = 49.
 *
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 *
 * [Medium] https://leetcode.com/problems/container-with-most-water/description/
 */
class ContainerWithMostWater {

    private fun maxArea(height: IntArray): Int {
        var maxArea = 0
        var left = 0
        var right = height.size - 1

        while (left < right) {
            val area = (right - left) * min(height[left], height[right])
            if (area > maxArea) {
                maxArea = area
            }

            if (height[left] > height[right]) {
                right--
            } else {
                left++
            }
        }

        return maxArea
    }
}