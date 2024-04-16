package com.example.algorithm.array

/**
 * 2 strings are equivalent when first string can move X times to become second string.
 * Example: "abcd" move 2 times become "cdef" (X = 2)
 * Explanation: "a" move 2 times become "c"
 *
 * "abcd" Equivalent "zabc" with X = 26
 */
class GroupOfSpecialEquivalentString {

    fun execute() {
        println(groupEquivalentString(listOf("abcd", "cdef", "zabc", "xyzz", "zabb", "zzyx")))
    }

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
                result.add(arrayListOf<String>(element))
            }
        }

        return result
    }

    private fun String.isEquivalent(text: String): Boolean {
        if (this.length != text.length) {
            return false
        }
        val hashSet = hashSetOf<Int>()
        for (i in 0 until this.length) {
            val absDiff = if (this[i] > text[i]) {
                Math.abs(this[i] - text[i])
            } else {
                26 - Math.abs((this[i] - text[i]))
            }

            hashSet.add(absDiff)
        }

        return hashSet.size == 1
    }
}