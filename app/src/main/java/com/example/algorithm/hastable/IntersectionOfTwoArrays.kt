package com.example.algorithm.hastable

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique and you may return the result in any order.
 *
 * The intersection of two arrays is defined as the set of elements that are present in both arrays.
 *
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 *
 * Example 3:
 * Input: nums1 = [4,0,5], nums2 = [9,4,9,8,5]
 * Output: [4, 5]
 *
 * [Easy] https://leetcode.com/problems/intersection-of-two-arrays/description/
 */
class IntersectionOfTwoArrays {

    private fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val hashSet = hashSetOf<Int>()
        val output = hashSetOf<Int>()
        nums1.forEach { element ->
            hashSet.add(element)
        }
        nums2.forEach { element ->
            if (hashSet.contains(element)) {
                output.add(element)
            }
        }

        return output.toIntArray()
    }
}