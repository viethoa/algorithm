package com.example.algorithm.hastable

/**
 * Easy: First Unique Character in a String
 *
 * Given a string s, write a program to find the first non-repeating character in it and return its index.
 * - If there is no non-repeating character in the string s, return -1.
 * - You may assume the string s contains only lowercase characters
 *
 * Example
 * Input: s = "afteracademy"
 * Output: 1
 * Explanation: 'f' is the first non-repeating character in the string s. Hence, the output is index 1.
 */
class FirstUniqueCharacterInString {

    /**
     * Time complexity: O(n)
     * Auxiliary Space: O(n)
     */
    fun execute(input: String): Int {
        if (input.isEmpty()) {
            return -1
        }

        val hashtable = HashMap<Char, Int>()
        input.forEach { character ->
            val count = hashtable[character]
            if (count == null) {
                hashtable[character] = 1
            } else {
                hashtable[character] = count + 1
            }
        }
        input.forEachIndexed { index, character ->
            if (hashtable[character] == 1) {
                return index
            }
        }

        return -1
    }
}