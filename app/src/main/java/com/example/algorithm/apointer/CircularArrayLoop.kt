package com.example.algorithm.apointer

/**
 * [Medium] https://leetcode.com/problems/circular-array-loop/description/
 */
class CircularArrayLoop {

    /**
     * Not yet cover this input [-1,-2,-3,-4,-5]
     */
    private fun circularArrayLoop(nums: IntArray): Boolean {
        val n = nums.size
        for (i in 0 until n) {
            if (detectCircular(nums, n, i)) {
                return true
            }
        }

        return false
    }

    private fun detectCircular(nums: IntArray, n: Int, position: Int): Boolean {
        val visited = hashSetOf<Int>()
        var i: Int = position

        while (!visited.contains(i)) {
            visited.add(i)

            // Next position
            var nextPosition = (i + nums[i]) % n
            if (nextPosition < 0) {
                nextPosition += n
            }
            i = nextPosition
        }

        // Check for conditions
        if (visited.size <= 1) {
            return false
        }
        val isPositive = nums[visited.first()] > 0
        visited.forEach { index ->
            if (isPositive && nums[index] < 0) {
                return false
            }
            if (!isPositive && nums[index] > 0) {
                return false
            }
        }

        return true
    }
}