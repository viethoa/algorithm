package com.example.algorithm.apointer

/**
 * Given an array nums with n objects colored red, white, or blue,
 * sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent
 * the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 *
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 *
 * [Medium] https://leetcode.com/problems/sort-colors/description/
 */
class SortColor {

    fun execute() {
        var intArray = intArrayOf(2, 0, 2, 1, 1, 0)
        sortColor(intArray)
        println(intArray.toList())

        intArray = intArrayOf(2, 0, 1)
        sortColor(intArray)
        println(intArray.toList())
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private fun sortColor(nums: IntArray) {
        var count0 = 0
        var count1 = 0
        nums.forEach { element ->
            when (element) {
                0 -> count0++
                1 -> count1++
            }
        }

        var i = 0
        while (i < nums.size) {
            when {
                count0 >= 0 -> {
                    nums[i] = 0
                    count0--
                }
                count1 >= 0 -> {
                    nums[i] = 1
                    count1--
                }
                else -> {
                    nums[i] = 2
                }
            }
            i++
        }
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private fun sortColor2(nums: IntArray) {
        var size = nums.size
        for (i in 2 downTo 0) {
            size = moveXToTheEnd(nums, size, i)
        }
    }

    private fun moveXToTheEnd(nums: IntArray, n: Int, x: Int): Int {
        var j = 0
        // Move all items except X into front
        for (i in 0 until n) {
            if (nums[i] != x) {
                nums[j] = nums[i]
                j++
            }
        }
        // Set X item at the bottom
        for (i in j until n) {
            nums[i] = x
        }

        return j
    }
}