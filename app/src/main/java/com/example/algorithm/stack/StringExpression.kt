package com.example.algorithm.stack

import java.lang.Exception
import java.util.*

/**
 * Given an expression as a string str consisting of numbers and basic arithmetic operators(+, -, *, /),
 * the task is to solve the expression.
 * Note that the numbers used in this program are single-digit numbers and parentheses are not allowed.
 * - https://www.geeksforgeeks.org/parsing-string-of-symbols-to-expression/
 *
 * Input: str = “3/3+4*6-9”
 * Output: 16
 * Since (3 / 3) = 1 and (4 * 6) = 24.
 * So the overall expression becomes (1 + 24 – 9) = 16
 *
 * Input: “9*5-4*5+9”
 * Output: (45 - 20 + 9) = 34
 */
class StringExpression {

    fun execute() {
        println(stringExpression("2+3*4/3-2"))
        println(stringExpression("9*5-4*5+9"))
    }

    /**
     * 1. Op1: (+ or –) and Op2: (* or /), e.g 3+4/ => push into stack
     * 2. Op1: (* or /) and Op2: (* or /), e.g 3*4/ => execute previous operator, push result into stack
     * 3. Op1: (+ or -) and Op2: (+ or -), e.g 3+4- => execute previous operator, push result into stack
     * 4. Op1: (* or /) and Op2: (+ or -), e.g 3*4+ => execute previous operator, push result into stack
     */
    private fun stringExpression(input: String): Int {
        val operators = Stack<String>()
        val digits = Stack<Int>()
        input.forEach { character ->
            when {
                character.isDigit() -> digits.push(character.toString().toInt())
                isSupportedOperator(character.toString()) -> {
                    // Doing possible operators
                    while (
                        operators.isNotEmpty() &&
                        shouldExecuteOperator(operators.peek(), character.toString())
                    ) {
                        digits.push(performOperator(operators.pop(), digits.pop(), digits.pop()))
                    }

                    operators.push(character.toString())
                }
                else -> {
                    throw Exception("Unsupported operator $character")
                }
            }
        }

        while (!operators.isEmpty()) {
            digits.push(performOperator(operators.pop(), digits.pop(), digits.pop()))
        }

        return digits.pop()
    }

    private fun shouldExecuteOperator(op1: String, op2: String): Boolean {
        return when {
            (op1 == "+" || op1 == "-") && (op2 == "*" || op2 == "/") -> false
            else -> true
        }
    }

    private fun performOperator(operator: String, b: Int, a: Int): Int {
        return when (operator) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> {
                if (b == 0) throw Exception("Cannot be divided to zero")
                else a / b
            }
            else -> throw Exception("Unsupported operator $operator")
        }
    }

    private fun isSupportedOperator(operator: String): Boolean {
        return when (operator) {
            "+", "-", "*", "/" -> true
            else -> false
        }
    }
}