package com.example.algorithm.hastable

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 */
class GroupAnagrams {

    fun execute() {
        val testCase1 = listOf("eat", "tea", "tan", "ate", "nat", "bat")
        val testCase2 = listOf("")
        val testCase3 = listOf("a")
        val result1 = groupAnagrams2(testCase1)
        println(result1)
        val result2 = groupAnagrams2(testCase2)
        println(result2)
        val result3 = groupAnagrams2(testCase3)
        println(result3)
    }

    /**
     * O(n * Log(n))
     */
    private fun groupAnagrams2(strs: List<String>): List<List<String>> {
        val hashMap = hashMapOf<String, ArrayList<String>>()
        strs.forEach { str ->
            val sortedStr = str
                .split("")
                .sorted()
                .joinToString()

            when {
                hashMap.contains(sortedStr) -> {
                    hashMap[sortedStr] = hashMap[sortedStr]!!.apply { add(str) }
                }
                else -> {
                    hashMap[sortedStr] = arrayListOf(str)
                }
            }
        }

        return hashMap.map { it.value }
    }

    private fun String.isAnagrams(str: String): Boolean {
        if (this.length != str.length) {
            return false
        }

        val hashMap = hashMapOf<Char, Int>()
        this.forEach { char ->
            if (hashMap.contains(char)) {
                hashMap[char] = hashMap[char]!! + 1
            } else {
                hashMap[char] = 1
            }
        }
        str.forEach { char ->
            if (hashMap.contains(char)) {
                hashMap[char] = hashMap[char]!! - 1
            } else {
                return false
            }
        }

        hashMap.forEach { (_, value) ->
            if (value != 0) {
                return false
            }
        }

        return true
    }
}