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
     * Solution (can use While instead of For)
     * 1. Calculate the Final-K = K % input-size (only need to do k % input-size time)
     * 2. Insert item from K to End list into temp array
     * 3. Insert item from start to K into temp array
     * 4. Copy temp array into original array
     */
    fun execute(input: List<Int>, k: Int): List<Int> {
        if (input.isEmpty()) {
            return input
        }
        if (k <= 0) {
            return input
        }

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