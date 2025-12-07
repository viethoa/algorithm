package com.example.algorithm.stack

import java.util.*

/**
 * Medium - Check for balanced parentheses in an expression
 *
 * You are given a string s consisting of characters: (, ), [, ], { and }.
 * Write a program to check whether the characters in the string s are valid or not.
 * - A string if said to be valid if an open parenthesis is closed by the same type of parenthesis.
 * - Also, the open parenthesis must be closed in the correct order.
 *
 * Example 1:
 * Input: "(([](){}))"
 * Output: true
 *
 * Example 2:
 * Input: "([)]"
 * Output: false
 */
class CheckBalanceOfParenthesis {

    fun isBalance(input: String): Boolean {
        val stack = Stack<Char>()
        input.forEach { char ->
            when(char) {
                '(',
                '{',
                '[' -> stack.push(char)
                else -> {
                    if (stack.isEmpty() || !isBalance(stack.pop(), char)) {
                        return false
                    }
                }
            }
        }

        return stack.isEmpty()
    }

    private fun isBalance(open: Char, close: Char): Boolean {
        return when (open) {
            '(' -> close == ')'
            '{' -> close == '}'
            '[' -> close == ']'
            else -> false
        }
    }
}