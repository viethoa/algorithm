package com.example.algorithm.array

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 *
 * Example 3:
 * Input: nums = [1]
 * Output: 1
 */
class SingleNumber {

    fun execute() {
        //println(singleNumber(intArrayOf(1)))
        //println(singleNumber(intArrayOf(2, 2, 1)))
        println(singleNumber(intArrayOf(4, 1, 2, 1, 2)))
    }

    /**
     * Using bitwise XOR operation
     *
     * Let's perform a bitwise XOR between 5 (binary: 101) and 6 (binary: 110).
     *  1 0 1
     *  1 1 0
     *  ==> result 011, therefore, 5 XOR 6 = 3
     */
    private fun singleNumber(nums: IntArray): Int {
        var result = 0
        for (num in nums) {
            result = num xor result
        }

        return result
    }
}