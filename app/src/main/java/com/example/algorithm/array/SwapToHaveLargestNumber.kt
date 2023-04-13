package com.example.algorithm.array

/**
 * Swap one time only to have a largest number
 * Input: 1973
 * Output: 9173
 *
 * Input: 92883
 * Output: 98283
 *
 * Input: 9832
 * Output: 9832
 */
class SwapToHaveLargestNumber {

    /**
     * O(nlog(n)) solution
     * - The Quick Sort is O(nlog(n))
     */
    fun useSortSolution(input: List<Int>): List<Int> {
        if (input.isEmpty()) {
            return input
        }

        var swapJValue: Int? = null
        var swapIPosition: Int? = null
        var swapJPosition: Int? = null
        val mutableList = input.toMutableList()
        val sortedList = input.sortedDescending()
        for (i in mutableList.indices) {
            if (mutableList[i] < sortedList[i]) {
                swapIPosition = i
                swapJValue = sortedList[i]
                break
            }
        }

        // The origin input already a largest number
        if (swapIPosition == null) {
            return mutableList
        }

        // Find swapJPosition
        for (i in mutableList.indices) {
            if (mutableList[i] == swapJValue) {
                swapJPosition = i
                break
            }
        }

        swapValue(swapIPosition, swapJPosition!!, mutableList)
        return mutableList
    }

    /**
     * O(n^2) solution
     */
    fun useLoopSolution(input: List<Int>): List<Int> {
        if (input.isEmpty()) {
            return input
        }

        val mutableInput = input.toMutableList()
        for (i in 0 until input.size - 1) {
            for (j in i + 1 until input.size) {
                if (input[i] < input[j]) {
                    swapValue(i, j, mutableInput)
                    break
                }
            }
        }

        return mutableInput
    }

    private fun swapValue(i: Int, j: Int, input: MutableList<Int>) {
        val temp = input[i]
        input[i] = input[j]
        input[j] = temp
    }
}