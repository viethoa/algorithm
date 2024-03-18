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
     * Solution O(n(n+1)/2)
     * Find all possible substring and check any of them is palindrome
     * - Not count 1 character
     * - Count from 2 characters to [input.length] characters
     */
    fun solution(input: String): Int {
        if (input.length <= 1) {
            return 0
        }

        var subString = 2
        val palindromes = mutableListOf<String>()
        while (subString <= input.length) {
            for (i in 0..input.length - subString) {
                val temp = input.substring(i, i + subString)
                if (temp.isPalindromeString()) {
                    palindromes.add(temp)
                }
            }
            subString += 1
        }

        // Second solution
//        for (i in 2..input.length) {
//            for (j in 0..input.length - i) {
//                val subString = input.substring(j, j + i)
//                if (isPalindromeString(subString)) {
//                    palindromes.add(subString)
//                }
//            }
//        }

        println(palindromes)
        return palindromes.size
    }
}

private fun String.isPalindromeString(): Boolean {
    return this == this.reversed()
}