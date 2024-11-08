package com.example.algorithm.array

/**
 * Swap one time only to have a largest number
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
        println(swapToHaveLargeNumber("1973"))
        println(swapToHaveLargeNumber("92938"))
        println(swapToHaveLargeNumber("92438"))
        println(swapToHaveLargeNumber("9832"))
    }

    private fun swapToHaveLargeNumber(number: String): String {
        var largest = Int.MIN_VALUE
        var largestIndex: Int? = null
        var leftPosition: Int? = null
        var rightPosition: Int? = null

        for (i in (number.length - 1) downTo 0) {
            val char = number[i].toString().toInt()
            // Check largest first
            if (char > largest) {
                largest = char
                largestIndex = i
            }
            // Check for possible swapping
            if (char < largest) {
                rightPosition = largestIndex
                leftPosition = i
            }
        }

        if (leftPosition != null && rightPosition != null) {
            return performSwap(number, leftPosition, rightPosition)
        }

        return number
    }

    private fun performSwap(number: String, left: Int, right: Int): String {
        var newNumber = ""
        for (i in number.indices) {
            newNumber += when (i) {
                right -> number[left]
                left -> number[right]
                else -> number[i]
            }
        }
        return newNumber
    }
}