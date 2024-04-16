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
        println("Loop Solution")
        println(useLoopSolution(listOf(1, 9, 7, 3)))
        println(useLoopSolution(listOf(9, 2, 8, 8, 3)))
        println(useLoopSolution(listOf(9, 8, 3, 2)))
        println("Sort Solution")
        println(swapToHaveLargeNumber("1973"))
        println(swapToHaveLargeNumber("92883"))
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

    /**
     * O(n^2) solution
     */
    private fun useLoopSolution(input: List<Int>): List<Int> {
        if (input.isEmpty()) {
            return input
        }

        val mutableInput = input.toMutableList()
        for (i in 0 until input.size - 1) {
            for (j in i + 1 until input.size) {
                if (input[i] < input[j]) {
                    swapValue(i, j, mutableInput)
                    break
                }
            }
        }

        return mutableInput
    }

    private fun swapValue(i: Int, j: Int, input: MutableList<Int>) {
        val temp = input[i]
        input[i] = input[j]
        input[j] = temp
    }

    /**
     * Sort solution
     * - Time: O(nlog(n)) (Quick Sort is O(nlog(n)))
     * - Space: O(N)
     */
    private fun useSortSolution(input: Int): Int {
        // Parse input to list of Character Integers
        val numbers = arrayListOf<Int>()
        input
            .toString()
            .forEach { character ->
                numbers.add(character.toString().toInt())
            }

        // Find First-Position need to swap
        val sortedNumbers = numbers.sortedDescending()
        var firstPosition = -1
        for (i in 0 until numbers.size) {
            if (numbers[i] != sortedNumbers[i]) {
                firstPosition = i
                break
            }
        }
        // The input already a largest number, no need to do any swap
        if (firstPosition == -1) {
            return input
        }

        // Find Second-Position for swapping
        var secondPosition = -1
        for (i in 0 until numbers.size) {
            if (sortedNumbers[firstPosition] == numbers[i]) {
                secondPosition = i
                break
            }
        }

        // Perform swap
        val temp = numbers[firstPosition]
        numbers[firstPosition] = sortedNumbers[firstPosition]
        numbers[secondPosition] = temp
        return numbers
            .map { it.toString() }
            .reduce { acc, next ->
                "$acc$next"
            }
            .toInt()
    }
}