package com.example.algorithm.apointer

/**
 * Given an integer array nums sorted in non-decreasing order,
 * remove some duplicates in-place such that each unique element appears at most twice.
 * The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages,
 * you must instead have the result be placed in the first part of the array nums.
 * More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result.
 * It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 * Do not allocate extra space for another array.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Example 2:
 * Input: nums = [0,0,1,1,1,1,2,3,3]
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 * Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * [Medium] https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
class RemoveDuplicatedFromSortedArrayII {

    fun execute() {
        var nums = intArrayOf(1, 1, 1, 2, 2, 3)
        var k = removeDuplicated(nums)
        println(nums.dropLast(nums.size - k))

        nums = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
        k = removeDuplicated(nums)
        println(nums.dropLast(nums.size - k))
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private fun removeDuplicated(nums: IntArray): Int {
        var j = 0
        var count = 0
        for (i in 0 until nums.size - 1) {
            when {
                nums[i] == nums[i + 1] -> {
                    if (count < 2) {
                        nums[j] = nums[i]
                        count++
                        j++
                    }
                }
                else -> {
                    if (count < 2) {
                        nums[j] = nums[i]
                        j++
                    }
                    count = 0
                }
            }
        }

        // Handle last item
        if (count < 2) {
            nums[j] = nums[nums.size - 1]
            j++
        }

        return j
    }
}