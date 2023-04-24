package com.example.algorithm.array

import kotlin.math.abs

/**
 * An Array of integers is given, both +ve and -ve.
 * You need to find the two elements such that their sum is closest to zero.
 *
 * For the below array, program should print -80 and 85.
 * Input : [1, 60, -10, 70, -80, 85]
 * Out: -80, 85
 */
class MinAbsoluteSumPair {

    /**
     * Optimised using Sort
     * 1. Sort the array by absolute value
     * 2. Run one more for, check sum of arr[i-1] and arr[i]
     * if their absolute sum is less than min update min with their absolute value.
     *
     * Time Complexity: O(nlogn) (Quick Sort) (the complexity depend on Sort method)
     * Auxiliary Space : O(1)
     */
    fun minAbsSumPairOptimise(array: List<Int>): Pair<Int, Int> {
        if (array.isEmpty() || array.size < 2) {
            throw java.lang.IllegalArgumentException("Wrong input, the array must be at least 2 element")
        }

        val sortedArray = array.sortedBy { abs(it) }
        var firstElement = 0
        var secondElement = 1
        var minSum = array[firstElement] + array[secondElement]
        for (i in 1 until sortedArray.size) {
            val sum = sortedArray[i - 1] + sortedArray[i]
            if (abs(sum) < abs(minSum)) {
                minSum = sum
                firstElement = i - 1
                secondElement = i
            }
        }

        return Pair(array[firstElement], array[secondElement])
    }

    /**
     * Time complexity: O(n^2)
     * Auxiliary Space: O(1)
     */
    fun minAbsSumPair(array: List<Int>): Pair<Int, Int> {
        if (array.isEmpty() || array.size < 2) {
            throw java.lang.IllegalArgumentException("Wrong input, the array must be at least 2 element")
        }

        var firstElement = 0
        var secondElement = 1
        var minSum = array[0] + array[1]
        for (i in 0 until array.size - 1) {
            for (j in i + 1 until array.size) {
                val sum = array[i] + array[j]
                if (abs(minSum) > abs(sum)) {
                    minSum = sum
                    firstElement = i
                    secondElement = j
                }
            }
        }

        return Pair(array[firstElement], array[secondElement])
    }
}