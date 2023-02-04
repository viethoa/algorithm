package com.example.algorithm.array

import kotlin.math.abs

/**
 * Medium - Minimum Absolute Difference
 *
 * You are given an array of distinct integers arr[],
 * write a program to find all pairs of elements such that their absolute difference is minimum.
 * Return a list of pairs in ascending order (with respect to pairs), each pair [i, j] follows:
 * - i, j are from arr[]
 * - i < j
 * - j - i equals to the minimum absolute difference of any two elements in arr[].
 *
 * Example 1
 * Input: arr[] = [5, 3, 2, 4]
 * Output: [[2, 3],[3, 4],[4, 5]]
 * Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
 *
 * Example 2
 * Input: arr[] = [2, 4, 7, 13, 17]
 * Output: [[2, 4]]
 * Explanation: The minimum absolute difference is 2 between the first two elements.
 *
 * Example 3
 * Input: arr[] = [1, 7, -12, 22, -8, -16, 18]
 * Output: [[-12, -8],[-12, -16],[22, 18]]
 * Explanation: All these pairs have the same minimum absolute difference.
 */
class MinimumAbsoluteDifference {

    /**
     * Solution
     * 1. Sort array
     * 2. Find minimum absolute diff number
     * 2. Find the pair which right minimum
     *
     * Time Complexity: O(nlogn) (Quick Sort) (the complexity depend on Sort method)
     * Auxiliary Space : O(n/2)
     */
    fun execute(input: List<Int>): List<Pair<Int, Int>> {
        if (input.isEmpty()) {
            return emptyList()
        }
        if (input.size == 1) {
            return emptyList()
        }

        //val sortedArray = input.sorted()
        val sortedArray = selectionSort(input.toTypedArray())
        var minAbsNumber = Int.MAX_VALUE
        for (i in 1 until sortedArray.size) {
            val min = abs(sortedArray[i] - sortedArray[i - 1])
            if (min < minAbsNumber) {
                minAbsNumber = min
            }
        }

        val result = arrayListOf<Pair<Int, Int>>()
        for (i in 1 until sortedArray.size) {
            val min = abs(sortedArray[i] - sortedArray[i - 1])
            if (min == minAbsNumber) {
                result.add(Pair(sortedArray[i - 1], sortedArray[i]))
            }
        }

        return result
    }

    private fun selectionSort(input: Array<Int>): Array<Int> {
        if (input.isEmpty() || input.size == 1) {
            return input
        }

        for (i in 0 until input.size - 1) {
            for (j in i until input.size) {
                if (input[i] > input[j]) {
                    permutation(input, i, j)
                }
            }
        }

        return input
    }

    private fun permutation(input: Array<Int>, i: Int, j: Int) {
        if (i < 0 || j < 0) {
            return
        }
        if (i >= input.size || j >= input.size) {
            return
        }
        val temp = input[i]
        input[i] = input[j]
        input[j] = temp
    }
}