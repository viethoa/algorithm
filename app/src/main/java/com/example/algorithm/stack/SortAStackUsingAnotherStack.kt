package com.example.algorithm.stack

import java.util.*

/**
 * Medium - Sort a stack using another stack
 *
 * You are given a stack of integers st, write a program to sort it.
 * You can use another stack if needed.
 * The top of the stack must point to the smallest element.
 * The stack must be sorted in increasing order from the top of the stack to its bottom.
 *
 * Example
 * Input: Top -> [4, 3, 1, 6, 2, 5]
 * Output: Top -> [1, 2, 3, 4, 5, 6]
 * Explanation: All the elements of the given stack are sorted with minimum element at the top of the stack.
 */
class SortAStackUsingAnotherStack {

    /**
     * Solution:
     * 1. Create a new output-stack
     * 2. Pop element from input-stack and push into output-stack
     * - When push into output stack, make sure element bigger then top-element, if not
     * - Pop top-element and push back into input-stack until top-element is smaller than element
     */
    fun execute(input: Stack<Int>): Stack<Int> {
        if (input.isEmpty() || input.size == 1) {
            return input
        }

        val outputStack = Stack<Int>()
        while (!input.isEmpty()) {
            val element = input.pop()
            while (!outputStack.isEmpty() && outputStack.peek() > element) {
                input.push(outputStack.pop())
            }
            outputStack.push(element)
        }

        return outputStack
    }
}