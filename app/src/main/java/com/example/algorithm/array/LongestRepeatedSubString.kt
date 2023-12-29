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
     * Complexity: O(n^2/2)
     */
    fun execute(input: String): String {
        val haftLength = input.length / 2
        var longestSubString = ""

        for (subLength in 1..haftLength) {
            val newLength = input.length - subLength
            for (i in 0..newLength) {
                val subString = input.substring(i, i + subLength)
                val (leftRemainString, rightRemainString) = getRemainString(input, i, subLength)
                if (leftRemainString.contains(subString) || rightRemainString.contains(subString)) {
                    if (subString.length > longestSubString.length) {
                        longestSubString = subString
                    }
                }
            }
        }

        return longestSubString
    }

    private fun getRemainString(input: String, i: Int, subLength: Int): Pair<String, String> {
        if (i == 0) {
            val restOfString = input.substring(subLength, input.length)
            return Pair("", restOfString)
        }
        if (i + subLength == input.length) {
            val restOfString = input.substring(0, input.length - subLength)
            return Pair(restOfString, "")
        }
        val leftSubString = input.substring(0, i)
        val rightSubString = input.substring(i + subLength, input.length)
        return Pair(leftSubString, rightSubString)
    }
}