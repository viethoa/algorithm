package com.example.algorithm.hastable

import kotlin.math.abs

/**
 * 2 strings are equivalent when first string can move X times to become second string.
 * Example:
 *  - "abcd" move 2 times become "cdef" (X = 2)
 *  - "abcd" Equivalent "zabc" (X = 26)
 *
 * Explanation:
 *  - "a" move 2 times become "c"
 *  - "a" move 26 times become z
 *
 * Input: ["abcd", "cdef", "zabc", "xyzz", "zabb", "zzyx"]
 * Output: [[abcd, cdef, zabc], [xyzz, zabb], [zzyx]]
 */
class GroupOfSpecialEquivalentString {

    fun execute() {
        println(groupEquivalentString(listOf("abcd", "cdef", "zabc", "xyzz", "zabb", "zzyx")))
        println(groupOfEquivalentString(listOf("abcd", "cdef", "zabc", "xyzz", "zabb", "zzyx")))
    }

    /**
     * Time Complexity: O(n)
     */
    private fun groupOfEquivalentString(input: List<String>): List<List<String>> {
        val hashMap = hashMapOf<String, ArrayList<String>>()
        input.forEach { element ->
            val x = element.first().code - 97 // 97 is 'a' in character
            val newString = element.moveXTime(x)
            if (hashMap.contains(newString)) {
                hashMap[newString]!!.add(element)
            } else {
                hashMap[newString] = arrayListOf(element)
            }
        }

        return hashMap.map { it.value }
    }

    private fun String.moveXTime(x: Int): String {
        var newString = ""
        for (i in indices) {
            newString += when {
                (this[i] - x < 'a') -> (this[i] - x) + 26 // e.g: 'b' - 2 = 'y' ==> need to +26
                else -> this[i] - x
            }
        }

        return newString
    }

    /**
     * Time Complexity: O(n log(n))
     */
    private fun groupEquivalentString(input: List<String>): List<List<String>> {
        val result = arrayListOf<ArrayList<String>>()
        input.forEach { element ->
            var equivalentInExistingGroup = false
            result.forEach { group ->
                if (group[0].isEquivalent(element)) {
                    group.add(element)
                    equivalentInExistingGroup = true
                }
            }

            if (!equivalentInExistingGroup) {
                result.add(arrayListOf(element))
            }
        }

        return result
    }

    private fun String.isEquivalent(text: String): Boolean {
        if (this.length != text.length) {
            return false
        }
        val hashSet = hashSetOf<Int>()
        for (i in indices) {
            val absDiff = if (this[i] > text[i]) {
                abs(this[i] - text[i])
            } else {
                26 - abs((this[i] - text[i]))
            }

            hashSet.add(absDiff)
        }

        return hashSet.size == 1
    }
}