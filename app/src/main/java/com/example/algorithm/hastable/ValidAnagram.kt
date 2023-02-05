package com.example.algorithm.hastable

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Example:
 * Input: str1 = “listen”  str2 = “silent”
 * Output: true
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 */
class ValidAnagram {

    fun solution1(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }

        val map = hashMapOf<Char, Int>()
        s.forEach { char ->
            if (map.contains(char)) {
                map[char] = map[char]!! + 1
            } else {
                map[char] = 1
            }
        }
        t.forEach { char ->
            if (map.contains(char)) {
                map[char] = map[char]!! - 1
            }
        }
        map.forEach { (_, value) ->
            if (value != 0) {
                return false
            }
        }

        return true
    }

    fun solution2(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }

        val sMap = hashMapOf<Char, Int>()
        s.forEach { char ->
            if (sMap.contains(char)) {
                sMap[char] = sMap[char]!! + 1
            } else {
                sMap[char] = 1
            }
        }
        val tMap = hashMapOf<Char, Int>()
        t.forEach { char ->
            if (tMap.contains(char)) {
                tMap[char] = tMap[char]!! + 1
            } else {
                tMap[char] = 1
            }
        }

        if (sMap.size != tMap.size) {
            return false
        }
        sMap.forEach { (key, value) ->
            if (!tMap.contains(key)) {
                return false
            }
            if (tMap[key] != value) {
                return false
            }
        }

        return true
    }
}