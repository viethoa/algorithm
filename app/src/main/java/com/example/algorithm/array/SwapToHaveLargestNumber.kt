package com.example.algorithm.array

/**
 * Swap one time only to have a largest number
 * Input: 1973
 * Output: 9173
 *
 * Input: 92883
 * Output: 98283
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
        println(useSortSolution(1973))
        println(useSortSolution(92883))
        println(useSortSolution(9832))
    }

    /**
     * O(nlog(n)) solution
     * - The Quick Sort is O(nlog(n))
     */
    private fun useSortSolution(input: Int): Int {
        // Parse input to list of Character Integers
        val numbers = arrayListOf<Int>()
        input
            .toString()
            .forEach { character ->
                numbers.add(character.toString().toInt())
            }

        // Find first position need to swap
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

        // Find the second position for swapping
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
}