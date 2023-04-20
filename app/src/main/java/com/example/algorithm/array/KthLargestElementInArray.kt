package com.example.algorithm.array

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 *
 * Example 2:
 * Input: nums = [6, 2, 3, 1, 2, 4, 5, 5, 6], k = 4
 * Output: 5
 */
class KthLargestElementInArray {

    /**
     * O(k*n) Solution
     */
    fun solution(input: List<Int>, k: Int): Int? {
        val kSortedElements = mutableListOf<Int>()
        val kElementPositions = mutableListOf<Int>()
        for (i in 0 until k) {
            var kLargest = Integer.MIN_VALUE
            val threshold = kSortedElements.lastOrNull()
            var kLargestIndex = -1
            input.forEachIndexed { index, element ->
                when (threshold) {
                    null -> {
                        if (kLargest < element) {
                            kLargest = element
                            kLargestIndex = index
                        }
                    }
                    else -> {
                        if (kLargest <= element &&
                            kLargest <= threshold &&
                            !kElementPositions.contains(index)
                        ) {
                            kLargest = element
                            kLargestIndex = index
                        }
                    }
                }
            }

            kSortedElements.add(kLargest)
            kElementPositions.add(kLargestIndex)
        }

        return kSortedElements.last()
    }
}