package com.example.algorithm.array

/**
 * Given an array arr[] of n integers, construct a Product Array prod[] (of the same size)
 * such that prod[i] is equal to the product of all the elements of arr[] except arr[i].
 * Note: Solve it without the division operator in O(n) time.
 * - https://www.geeksforgeeks.org/a-product-array-puzzle/
 *
 * Example
 * Input: {10, 3, 5, 6, 2}
 * Output: {180, 600, 360, 300, 900}
 * - 180 = 3 * 5 * 6 * 2 (except 10)
 * - 600 = 10 * 5 * 6 * 2 (except 3)
 * - 360 = 10 * 3 * 6 * 2 (except 5)
 * - 300 = 10 * 3 * 5 * 2 (except 6)
 * - 900 = 10 * 3 * 6 * 5 (except 2)
 *
 * Input: {1, 2, 3, 4, 5}
 * Output: {120, 60, 40, 30, 24}
 */
class ProductOfArrayExceptSelf {

    fun execute() {
        println(
            productArray(intArrayOf(1, 2, 3, 4, 5)).toList()
        )
    }

    /**
     * Solution 1: A naive approach
     * Store the product of all the elements is variable and then iterate the array
     * and add product/current_index_value in a new array. and then return this new array.
     * But as per the problem statement this is not a valid approach.
     */

    /**
     * Solution 2: An approach using prefix and suffix multiplication
     */
    private fun productArray(input: IntArray): IntArray {
        val prefix = IntArray(input.size)
        val suffix = IntArray(input.size)
        val product = IntArray(input.size)

        // Init Prefix
        for (i in input.indices) {
            when (i) {
                0 -> prefix[i] = 1
                else -> {
                    prefix[i] = prefix[i - 1] * input[i - 1]
                }
            }
        }

        // Init Suffix
        val start = input.size - 1
        for (i in start downTo 0) {
            when (i) {
                start -> suffix[i] = 1
                else -> {
                    suffix[i] = suffix[i + 1] * input[i + 1]
                }
            }
        }

        // Calculate product
        for (i in input.indices) {
            product[i] = prefix[i] * suffix[i]
        }

        return product
    }
}