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
 */
class PairWithGivenSum {

    fun execute(input: List<Int>, sum: Int): List<Pair<Int, Int>> {
        if (input.size <= 1) {
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

        val output = arrayListOf<Pair<Int, Int>>()
        input.forEach { element ->
            val difference = sum - element
            if (map.contains(difference)) {
                val mapElement = map[difference]
                for (i in 0..mapElement!!) {
                    output.add(Pair(element, difference))
                }
                map.remove(difference) /* Need to remove to avoid duplicated */
                map.remove(element) /* Need to remove to avoid duplicated */
            }
        }

        return output
    }
}