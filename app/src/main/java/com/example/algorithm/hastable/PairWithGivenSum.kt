package com.example.algorithm.hastable

/**
 * Given an array of integers, and a number ‘sum’,
 * print all pairs in the array whose sum is equal to ‘sum’.
 *
 * Examples:
 * Input: arr[] = {1, 5, 7, -1, 5},
 * sum = 6
 * Output: (1, 5) (7, -1) (1, 5)
 *
 * Input: arr[] = {2, 5, 17, -1},
 * sum = 7
 * Output: (2, 5)
 *
 * Input: arr[] = {1, 5, 3, 3, 3},
 * sum = 6
 * Output: (1, 5) (3, 3) (3, 3) (3, 3)
 *
 * Input: arr[] = {1, 5, 5, 1, 3},
 * sum = 6
 * Output: (1, 5) (1, 5) (5, 1) (5, 1)
 */
class PairWithGivenSum {

    fun execute(input: List<Int>, sum: Int): List<Pair<Int, Int>> {
        if (input.size <= 1) {
            return emptyList()
        }

        val result = arrayListOf<Pair<Int, Int>>()
        val hashMap = hashMapOf<Int, Int>()
        input.forEach { element ->
            val diff = sum - element
            if (hashMap.contains(diff)) {
                val count = hashMap[diff]!!
                for (i in 0 until count) {
                    result.add(Pair(diff, element))
                }
            }

            if (hashMap.contains(element)) {
                hashMap[element] = hashMap[element]!! + 1
            } else {
                hashMap[element] = 1
            }
        }

        return result
    }
}