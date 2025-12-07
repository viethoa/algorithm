package com.example.algorithm.array

/**
 * Swap one time only to have a largest number
 * https://leetcode.com/problems/maximum-swap/description/
 *
 * Input: 1973
 * Output: 9173
 *
 * Input: 92883
 * Output: 98823
 *
 * Input: 9832
 * Output: 9832
 */
class SwapToHaveLargestNumber {

    fun execute() {
        println("Sort Solution")
        println(swapToHaveLargeNumber(1973))
        println(swapToHaveLargeNumber(92938))
        println(swapToHaveLargeNumber(92438))
        println(swapToHaveLargeNumber(9832))
    }

    private fun swapToHaveLargeNumber(number: Int): Int {
        var largest = Int.MIN_VALUE
        var largestPos: Int? = null
        var leftPos: Int? = null
        var rightPos: Int? = null

        val numStr = number.toString()
        for (i in (numStr.length - 1) downTo 0) {
            val element = numStr[i].code
            if (element > largest) {
                largest = element
                largestPos = i
            }
            if (element < largest) {
                leftPos = i
                rightPos = largestPos
            }
        }

        if (rightPos != null && leftPos != null) {
            return performSwap(numStr, leftPos, rightPos)
        }

        return number
    }

    private fun performSwap(num: String, left: Int, right: Int): Int {
        var newNumber = ""
        num.forEachIndexed { index, value ->
            when (index) {
                left -> newNumber += num[right]
                right -> newNumber += num[left]
                else -> newNumber += value
            }
        }
        return newNumber.toInt()
    }
}