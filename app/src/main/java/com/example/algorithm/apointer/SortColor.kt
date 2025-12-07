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
        // Move all 0 to left
        val leftPosition = moveAllXToLeft(0, 0, nums)
        // Move all 1 to left from leftPosition
        if (leftPosition < nums.size - 1) {
            moveAllXToLeft(leftPosition, 1, nums)
        }
    }

    private fun moveAllXToLeft(begin: Int, number: Int, nums: IntArray): Int {
        var i = begin
        for (j in nums.indices) {
            if (nums[j] == number) {
                val temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
                i++
            }
        }
        return i
    }
}