package com.example.algorithm.array

/**
 * Count sub-arrays which have elements less than or equal to X
 *
 * Examples:
 * Input: {1, 5, 7, 8, 2, 3, 9}
 * X = 6
 * Output : 6
 * Explanation: Sub-arrays are {1}, {5}, {2}, {3}, {1, 5}, {2, 3}
 *
 * Input: {1, 10, 12, 4, 5, 3, 2, 7}
 * X = 9
 * Output : 16
 * Explanation: Sub-arrays are
 * 1. {1}
 * 2. {4}, {4, 5}, {4, 5, 3}, {4, 5, 3, 2}, {4, 5, 3, 2, 7}
 * 3. {5}, {5, 3}, {5, 3, 2}, {5, 3, 2, 7}
 * 4. {3}, {3, 2}, {3, 2, 7}
 * 5. {2} {2, 7}
 * 6. {7}
 *
 * Notes: {4, 5, 3, 2, 7} = n(n+1)/2 = (5 * 6) / 2 = 15
 */
class CountSubArray {

    /**
     * Time complexity: O(n)
     * Auxiliary Space: O(1)
     */
    fun execute(input: List<Int>, x: Int): Int {
        var count = 0
        var consecutive = 0
        input.forEach { element ->
            if (element <= x) {
                consecutive += 1
            } else {
                count += consecutive * (consecutive + 1) / 2
                consecutive = 0
            }
        }

        count += consecutive * (consecutive + 1) / 2
        return count
    }
}