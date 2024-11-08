package com.example.algorithm.array

/**
 * You are given a large integer represented as an integer array digits,
 * where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order.
 * The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The integer is 123, incrementing by one = 124. Thus, the result should be [1,2,4].
 *
 * Input: digits = [9]
 * Output: [1,0]
 *
 * Input: digits = [0]
 * Output: [1]
 *
 * [Easy] https://leetcode.com/problems/plus-one/description/
 */
class PlusOne {

    private fun plusOne(digits: IntArray): IntArray {
        var i = digits.size - 1

        // Move i to position which digits[i] < 9
        while (i >= 0 && digits[i] == 9) {
            digits[i] = 0
            i -= 1
        }
        // Plus 1 for possible position
        if (i >= 0) {
            digits[i] = digits[i] + 1
            return digits
        }

        // All digits are 9, need to create new list
        val newDigits = IntArray(digits.size + 1)
        newDigits.fill(0)
        newDigits[0] = 1
        return newDigits
    }
}