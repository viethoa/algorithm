package com.example.algorithm.array

/**
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 *  - rotate 1 steps to the right: [7,1,2,3,4,5,6]
 *  - rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * - rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 *
 * Explanation:
 * - rotate 1 steps to the right: [99,-1,-100,3]
 * - rotate 2 steps to the right: [3,99,-1,-100]
 * - The best answer is code with no for loop
 */
class RotationByKPosition {

    /**
     * Time Complexity: O(n)
     * Space complexity: O(n)
     */
    fun execute(input: List<Int>, k: Int): List<Int> {
        val finalK = k % input.size
        val output = arrayListOf<Int>()
        val kPositionFromTheEnd = input.size - finalK
        for (i in kPositionFromTheEnd until input.size) {
            output.add(input[i])
        }
        for (i in 0 until kPositionFromTheEnd) {
            output.add(input[i])
        }

        return output
    }
}