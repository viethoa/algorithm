package com.example.algorithm.hastable

/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3,3,4], k = 2
 * Output: [1,2,3]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 */
class TopKFrequentElements {

    fun execute() {
        val testCase1 = listOf(1, 1, 1, 2, 2, 3, 3, 4)
        println(mostFrequentElements(testCase1, 2))
        val testCase2 = listOf(1)
        println(mostFrequentElements(testCase2, 1))
    }

    private fun mostFrequentElements(input: List<Int>, k: Int): List<Int> {
        val hashMap = hashMapOf<Int, Int>()
        input.forEach { element ->
            if (hashMap.contains(element)) {
                hashMap[element] = hashMap[element]!! + 1
            } else {
                hashMap[element] = 1
            }
        }

        val result = arrayListOf<Int>()
        hashMap.forEach { (key, value) ->
            if (value >= k) {
                result.add(key)
            }
        }

        return result
    }
}