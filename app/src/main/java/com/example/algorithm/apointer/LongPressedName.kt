package com.example.algorithm.apointer

/**
 * Your friend is typing his name into a keyboard. Sometimes, when typing a character c,
 * the key might get long pressed, and the character will be typed 1 or more times.
 * You examine the typed characters of the keyboard. Return True if,
 * it is possible that it was your friends name, with some characters
 * (possibly none) being long pressed.
 *
 * Example:
 * input: name: "saeed", typed: "ssaaedd"
 * output: false, because "e" is missing
 *
 * input: name: "alex", typed: "aaleexa"
 * output: false, because "a" extra word
 *
 * input: name: "alex", typed: "aaleex"
 * output: true
 *
 * input: name: "alexd", typed: "ale"
 * output: false
 *
 * input: name: "pyplrz", typed: "ppyypllr"
 * output: false, because missing "z"
 *
 * input: name: "rick", typed: "kric"
 * output: false
 */
class LongPressedName {

    fun execute() {
        println(isLongPressedName("saeed", "ssaaedd"))
        println(isLongPressedName("alex", "aaleexa"))
        println(isLongPressedName("alex", "aaleex"))
        println(isLongPressedName("alexd", "ale"))
        println(isLongPressedName("pyplrz", "ppyypllr"))
        println(isLongPressedName("rick", "kric"))
    }

    private fun isLongPressedName(name: String, typed: String): Boolean {
        val n = name.length
        val m = typed.length
        if (m < n) {
            return false
        }

        var j = 0
        var i = 0
        while (i < n) {
            // Missing word in typed
            if (j >= m) {
                return false
            }
            // Char is not match
            if (name[i] != typed[j]) {
                return false
            }

            // Count concurrent of char
            var count1 = 1
            while (i < n - 1 && name[i] == name[i + 1]) {
                count1++
                i++
            }
            var count2 = 1
            while (j < m - 1 && typed[j] == typed[j + 1]) {
                count2++
                j++
            }
            if (count1 > count2) {
                return false
            }

            // Checking next word
            i++
            j++
        }

        // Possible as name
        return j == m
    }
}