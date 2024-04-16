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
        val stack = Stack<String>()
        for (char in input) {
            when {
                isOpenBracket(char.toString()) -> stack.push(char.toString())
                else -> {
                    if (!checkBalance(stack, char.toString())) {
                        return false
                    }
                }
            }
        }

        return stack.isEmpty()
    }

    private fun isOpenBracket(bracket: String): Boolean {
        return bracket == "(" || bracket == "[" || bracket == "{"
    }

    private fun checkBalance(stack: Stack<String>, element: String): Boolean {
        // Element is close bracket but not any opening bracket
        if (stack.isEmpty()) {
            return false
        }
        // Close bracket must be stick with an opening bracket
        val bracket = stack.pop()
        return when (element) {
            ")" -> bracket == "("
            "]" -> bracket == "["
            "}" -> bracket == "{"
            else -> false
        }
    }
}