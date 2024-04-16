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
     * input: 1 2 3 4 5 5 6 6
     * appear: [1:1] [2:1] [3:1] [4:1] [5:2] [6:2]
     * result: k = 3 => 5
     */

    /**
     * QuickSort O(N*logN)
     */
    private fun findKthLargestWithSort(input: List<Int>, k: Int): Int {
        return input.sortedDescending()[k]
    }

    /**
     * Time Complexity: O(k*n)
     * Space Complexity: O(k*n)
     */
    private fun findKthLargest(input: List<Int>, k: Int): Int {
        var mutableK = k
        var threshold = Int.MAX_VALUE
        var kthLargest = Int.MIN_VALUE
        val countedIndexes = arrayListOf<Int>()
        while (mutableK > 0) {
            val (largest, index) = findLargestWithThreshold(input, threshold, countedIndexes)
            kthLargest = largest
            threshold = largest
            countedIndexes.add(index)
            mutableK -= 1
        }

        return kthLargest
    }

    private fun findLargestWithThreshold(
        input: List<Int>,
        threshold: Int,
        countedIndexes: List<Int>
    ): Pair<Int, Int> {
        var largestIndex = -1
        var largest = Int.MIN_VALUE
        input.forEachIndexed { index, element ->
            if (element >= largest && element <= threshold && !countedIndexes.contains(index)) {
                largest = element
                largestIndex = index
            }
        }

        return Pair(largest, largestIndex)
    }
}