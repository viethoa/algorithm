package com.example.algorithm.apointer

import android.os.Build
import androidx.annotation.RequiresApi
import kotlin.math.max

/**
 * You are visiting a farm that has a single row of fruit trees arranged from left to right.
 * The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
 *
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 *  - You only have two baskets, and each basket can only hold a single type of fruit.
 *    There is no limit on the amount of fruit each basket can hold.
 *  - Starting from any tree of your choice, you must pick exactly one fruit from every tree
 *    (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
 *  - Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 *
 * Given the integer array fruits, return the maximum number of fruits you can pick.
 *
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 *
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 *
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees [1,2].
 *
 * [Medium] https://leetcode.com/problems/fruit-into-baskets/description/
 */
@RequiresApi(Build.VERSION_CODES.N)
class FruitIntoBaskets {

    /**
     * Dry run: [1,1,2,1,3,2,2,2,2,2,2]
     * Step 1: hm: (1), l: 1, maxx: 1, start: 0
     * Step 2: hm: (1), l: 2, maxx: 2, start: 0
     * Step 3: hm: (1,2), l: 3, maxx: 3, start: 0
     * Step 4: hm: (1,2), l: 4, maxx: 4, start: 0
     * Step 5: hm: (1,2,3), l: 5, maxx: _, start: 0
     *  - hm: (1,2,3), l: 4, start: 1
     *  - hm: (1,2,3), l: 3, start: 2
     *  - hm: (1,3), l: 2, start: 3
     */
    private fun totalFruit(fruits: IntArray): Int {
        var i = 0
        var start = 0
        var len = 0
        var maxFruits = 0
        val hashMap = hashMapOf<Int, Int>()

        while (i < fruits.size) {
            hashMap[fruits[i]] = hashMap.getOrDefault(fruits[i], 0) + 1
            len++

            // If count of number is more than K
            while (hashMap.size > 2) {
                hashMap[fruits[start]] = hashMap[fruits[start]]!! - 1
                len--

                // If all occurrences of number is erased
                if (hashMap[fruits[start]] == 0) {
                    hashMap.remove(fruits[start])
                }
                start++
            }

            maxFruits = max(maxFruits, len)
            i++
        }

        return maxFruits
    }
}










