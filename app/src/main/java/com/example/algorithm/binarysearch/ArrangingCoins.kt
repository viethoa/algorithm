package com.example.algorithm.binarysearch

/**
 * You have n coins and you want to build a staircase with these coins.
 * The staircase consists of k rows where the ith row has exactly i coins.
 * The last row of the staircase may be incomplete.
 *
 * Given the integer n, return the number of complete rows of the staircase you will build.
 *
 * Input: n = 5
 * Output: 2
 * Explanation: Because the 3rd row is incomplete, we return 2.
 *
 * Input: n = 8
 * Output: 3
 * Explanation: Because the 4th row is incomplete, we return 3.
 *
 * [Easy] https://leetcode.com/problems/arranging-coins/description/
 */
class ArrangingCoins {

    private fun arrangeCoins(n: Int): Int {
        var k = 1 // Number of coins in the current row
        var totalCoins = n
        while (totalCoins >= k) {
            totalCoins -= k  // Subtract coins used in the current row
            k++
        }

        return k - 1
    }
}