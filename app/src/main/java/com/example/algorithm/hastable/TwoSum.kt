package com.example.algorithm.hastable

/**
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * You can return the answer in any order.
 *
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * https://leetcode.com/problems/two-sum/
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */

class TwoSum {

    fun execute() {
        val input = intArrayOf(231, 342, -6, -10, 458)
        val result = twoSum(input, -16)
        println("Result $result")
    }

    private fun twoSum(input: IntArray, target: Int): Pair<Int, Int>? {
        val hashMap = hashMapOf<Int, Int>()
        input.forEachIndexed { index, element ->
            val temp = target - element
            if (hashMap.contains(temp)) {
                return Pair(index, hashMap[temp]!!)
            }

            hashMap[element] = index
        }

        return null
    }
}