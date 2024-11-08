package com.example.algorithm.array

/**
 * Given a string s, return the number of palindromic substrings in it.
 * A string is a palindrome when it reads the same backward as forward.
 *
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 * Input: s = "abaab"
 * Output: 8
 * Explanation: Six palindromic strings: "aba" , "aa" , "baab", "a", "b", "a", "a", "b"
 */
class CountAllPalindromeSubString {

    /**
     * Solution: O(n^2)
     * Find all possible substring and check any of them is palindrome
     */
    fun solution(input: String): Int {
        var count = 0
        for (i in 1..input.length) {
            for (j in 0..(input.length - i)) {
                val subString = input.substring(j, j + i)
                if (subString.isPalindromeString()) {
                    count += 1
                }
            }
        }

        return count
    }
}

private fun String.isPalindromeString(): Boolean {
    return this == this.reversed()
}