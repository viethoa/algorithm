package com.example.algorithm.array

/**
 * Given a string, the task is to count all palindrome sub string in a given string.
 * Length of palindrome sub string is greater than or equal to 2.
 *
 * Example
 * Input : str = "abaab"
 * Output: 3
 * Explanation :
 * All palindrome substring are :
 * "aba" , "aa" , "baab"
 *
 * Input : str = "abbaeae"
 * Output: 4
 * Explanation :
 * All palindrome substring are :
 * "bb" , "abba" ,"aea","eae"
 */
class CountAllPalindromeSubString {

    /**
     * Solution O(n^2)
     * Find all possible substring and check any of them is palindrome
     * - Not count 1 character
     * - Count from 2 characters to [input.length] characters
     */
    fun solution(input: String): Int {
        if (input.length <= 1) {
            return 0
        }

        val palindromes = mutableListOf<String>()
        for (i in 2..input.length) {
            for (j in 0..input.length - i) {
                val subString = input.substring(j, j + i)
                if (isPalindromeString(subString)) {
                    palindromes.add(subString)
                }
            }
        }

        println(palindromes)
        return palindromes.size
    }

    private fun isPalindromeString(subString: String): Boolean {
        return subString == subString.reversed()
    }
}