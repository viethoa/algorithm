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
 * @notes
 * - HashMap solution is not solve all cases
 * - Better use 2 loops
 */
class PairWithGivenSum {

    fun execute(input: List<Int>, sum: Int): List<Pair<Int, Int>> {
        if (input.isEmpty() || input.size == 1) {
            return emptyList()
        }

        // Add all item into map
        val map = hashMapOf<Int, Int>()
        input.forEach { element ->
            if (map.containsKey(element)) {
                map[element] = map[element]!! + 1
            } else {
                map[element] = 0
            }
        }

        // map contains difference = sum - element
        // Pair-Sum will be the count
        // - 1 Pair: ([difference, element])
        // - n(n-1)/2 Pairs: ([difference, element]... [difference, element])
        val result = arrayListOf<Pair<Int, Int>>()
        val sumMinusElements = arrayListOf<Int>()
        map.forEach { (element, count) ->
            val difference = sum - element
            if (map.contains(difference) && !sumMinusElements.contains(element)) {
                sumMinusElements.add(difference)
                for (i in 0..count) {
                    result.add(Pair(difference, element))
                }
            }
        }

        return result
    }
}