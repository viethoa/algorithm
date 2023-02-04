package com.example.algorithm.stack

import java.util.Stack

/**
 * Easy - Reverse a stack using recursion
 *
 * Given a stack of integers st, write a program to reverse the stack using recursion.
 * You are not allowed to use loop constructs like while, for..etc,
 * it is mandatory to reverse st using recursion.
 *
 * Example 1:
 * Input: st = [1, 5, 3, 2, 4]
 * Output: [4, 2, 3, 5, 1]
 *
 * Example 2:
 * Input: st = [5, 17, 100, 11]
 * Output: [11, 100, 17, 5]
 *
 * 1 5 3 2 4
 */
class ReverseStackUsingRecursion {

    fun execute(stack: Stack<Int>) {
        if (stack.isEmpty()) {
            return
        }

        // Hold all items in Function
        val element = stack.pop()
        execute(stack)

        // Insert all items held in Function one by one at the bottom
        insertAtBottom(stack, element)
    }

    private fun insertAtBottom(stack: Stack<Int>, value: Int) {
        if (stack.isEmpty()) {
            stack.push(value)
            return
        }

        // Hold all items in Function
        // and insert value as first item
        val element = stack.pop()
        insertAtBottom(stack, value)

        // Push all the held items back again
        stack.push(element)
    }
}