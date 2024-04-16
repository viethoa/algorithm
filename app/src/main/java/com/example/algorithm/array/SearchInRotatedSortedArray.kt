package com.example.algorithm.array

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at
 * an unknown pivot index k (1 <= k < nums.length) such that the resulting array is
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * - For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Input: [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * Input: [1], target = 0
 * Output: -1
 */
class SearchInRotatedSortedArray {

    /**
     * Solution is use Binary Search
     * Which has O(logN) Time Complexity
     */
    fun execute() {
        println(binarySearch(listOf(4, 5, 6, 7, 0, 1, 2), 0, 0, 6))
        println(binarySearch(listOf(4, 5, 6, 7, 0, 1, 2), 3, 0, 6))
        println(binarySearch(listOf(0, 1, 2, 4, 5, 6, 7), 0, 0, 6))
        println(binarySearch(listOf(0, 1, 2, 4, 5, 6, 7), 3, 0, 6))

        println(binarySearch(listOf(5, 6, 7, 8, 9, 10, 1, 2, 3), 3, 0, 8))
        println(binarySearch(listOf(5, 6, 7, 8, 9, 10, 1, 2, 3), 30, 0, 8))
        println(binarySearch(listOf(1, 2, 3, 5, 6, 7, 8, 9, 10), 3, 0, 8))
        println(binarySearch(listOf(1, 2, 3, 5, 6, 7, 8, 9, 10), 30, 0, 8))
    }

    private fun binarySearch(input: List<Int>, key: Int, low: Int, high: Int): Int {
        if (low > high) {
            return -1
        }
        val mid = (low + high) / 2
        if (input[mid] == key) {
            return mid
        }

        // First sub-array is sorted
        if (input[low] <= input[mid]) {
            // Find the key inside First sub-array
            if (key >= input[low] && key <= input[mid]) {
                return binarySearch(input, key, low, mid - 1)
            }
            // Find the key inside Second sub-array
            return binarySearch(input, key, mid + 1, high)
        }

        // If First sub-array is rotated => Second sub-array is sorted
        // Find key inside Second sub-array
        if (key >= input[mid] && key <= input[high]) {
            return binarySearch(input, key, mid + 1, high)
        }
        // Find the key inside First sub-array
        return binarySearch(input, key, low, mid - 1)
    }
}








