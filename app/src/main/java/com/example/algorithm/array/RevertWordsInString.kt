package com.example.algorithm.array

/**
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that is may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 * Example:
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 *
 * Input: s = "  hello world  "
 * Output: "world hello"
 *
 * Input: s = "a good   example"
 * Output: "example good a"
 */
class RevertWordsInString {

    fun execute() {
        println(revertWordsInString("the sky is blue"))
        println(revertWordsInString("  hello world  "))
        println(revertWordsInString("a good   example"))
    }

    private fun revertWordsInString(input: String): String {
        var temp = ""
        val stringBuilder = StringBuilder()

        for (character in input) {
            when (character) {
                ' ' -> {
                    insertString(stringBuilder, temp)
                    temp = ""
                }
                else -> {
                    temp += character.toString()
                }
            }
        }

        insertString(stringBuilder, temp)
        return stringBuilder.toString()
    }

    private fun insertString(stringBuilder: StringBuilder, value: String) {
        if (value.isNotEmpty()) {
            if (stringBuilder.isEmpty()) {
                stringBuilder.append(value)
            } else {
                stringBuilder.insert(0, "$value ")
            }
        }
    }
}