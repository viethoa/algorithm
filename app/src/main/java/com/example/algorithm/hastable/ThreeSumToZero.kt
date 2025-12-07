package com.example.algorithm.hastable

/**
 * Find 3 numbers in the list which is A + B + C = 0
 * - E.g: 10 + -7 + -3 = 0 => true
 * - https://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/
 *
 * Input: arr[] = {2, -3, 1}
 * Output: true
 *
 * Input: arr[] = {0, -1, 2, -3, 1}
 * Output: true
 *
 * Input: arr[] = {1, -2, -2, 0, 5}
 * Output: false
 *
 * Input: [0, -1, 5, 10, 14, -7, -3, 4, 1]
 * Output: true
 *
 * Input: [0, -3, 5, 10, 14, -7, -6, 2, 1]
 * Output: true
 *
 * Input: [3, 3, -2, 10, -7, 3, -6, 1]
 * Output: true
 *
 * Input: [0, 1, 5, 10, -7, 3, 8, 1]
 * Output: false
 *
 * https://leetcode.com/problems/3sum/description/
 */
class ThreeSumToZero {

    fun execute() {
        println(useHashSetSolution(listOf(2, -3, 1)))
        println(useHashSetSolution(listOf(0, -1, 2, -3, 1)))
        println(useHashSetSolution(listOf(1, -2, -2, 0, 5)))
        println(useHashSetSolution(listOf(0, -1, 5, 10, 14, -7, -3, 4, 1)))
        println(useHashSetSolution(listOf(0, -3, 5, 10, 14, -7, -6, 2, 1)))
        println(useHashSetSolution(listOf(3, 3, -2, 10, -7, 3, -6, 1)))
        println(useHashSetSolution(listOf(0, 1, 5, 10, -7, 3, 8, 1)))
    }

    /**
     * Solution: O(n^2)
     * - The idea is HashSet should contain only number which is not
     * input[i] and input[j].
     */
    private fun useHashSetSolution(input: List<Int>): Boolean {
        for (i in 0 until input.size - 1) {
            val hashSet = hashSetOf<Int>()
            for (j in i + 1 until input.size) {
                if (hashSet.contains(-(input[i] + input[j]))) {
                    return true
                }

                hashSet.add(input[j])
            }
        }

        return false
    }
}