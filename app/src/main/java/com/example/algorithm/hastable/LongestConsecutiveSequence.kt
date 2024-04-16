package com.example.algorithm.hastable

/**
 * Given an unsorted array of integers nums,
 * return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 *
 * Example 1:
 * Input: nums = [1, 9, 3, 10, 4, 20, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * Example 2:
 * Input: nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
 * Output: 9
 *
 * Example 3:
 * Input: arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}
 * Output: 5
 * Explanation: The subsequence 36, 35, 33, 34, 32 is the longest subsequence of consecutive elements.
 */
class LongestConsecutiveSequence {

    /**
     * Solution
     * 1. Loop and count till HashSet.contains(element + 1) is false
     * - Count = count - element
     * 2. If count > LCS, LCS = count
     */
    fun execute(input: List<Int>): Int {
        val set = hashSetOf<Int>()
        input.forEach { element ->
            if (!set.contains(element)) {
                set.add(element)
            }
        }

        var longestConsecutiveSequence = 0
        set.forEach { element ->
            var temp = element + 1
            while (set.contains(temp)) {
                temp++
            }
            val count = temp - element
            if (count > longestConsecutiveSequence) {
                longestConsecutiveSequence = count
            }
        }

        return longestConsecutiveSequence
    }
}