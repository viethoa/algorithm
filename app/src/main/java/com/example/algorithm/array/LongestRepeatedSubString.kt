package com.example.algorithm.array

/**
 * Find the longest repeated substring if there is a tie, give the first, but give the string as the output.
 *
 * Input : str = "geeksforgeeks"
 * Output : geeks
 *
 * Input : str = "aab"
 * Output : a
 *
 * Input : str = "aabaabaaba"
 * Output : aaba
 *
 * Input : str = "aaaaaaaaaaa"
 * Output : aaaaa
 *
 * Input : str = "banana"
 * Output : an or na
 */
class LongestRepeatedSubString {

    /**
     * Time Complexity: O((n^2)/2)
     * Space complexity: O(1)
     */
    fun execute(input: String): String? {
        val n = input.length
        val halfInputLength = input.length / 2
        var substringLength = 1
        var longestRepeatedSubString: String? = null

        while (substringLength <= halfInputLength) {
            for (i in 0 until (n - substringLength)) {
                val substring = input.substring(i, i + substringLength)
                val rightLeftSubstring = input.substring(i + substringLength, n)
                // Only need to check with Right-Leftover substring,
                // Because the Left-leftover substring already check at the begin when looping
                if (rightLeftSubstring.contains(substring)) {
                    when (longestRepeatedSubString) {
                        null -> longestRepeatedSubString = substring
                        else -> {
                            if (longestRepeatedSubString.length < substring.length) {
                                longestRepeatedSubString = substring
                            }
                        }
                    }
                }
            }

            substringLength += 1
        }

        return longestRepeatedSubString
    }
}