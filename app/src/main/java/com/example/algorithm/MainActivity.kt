package com.example.algorithm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.algorithm.array.CountSubArray
import com.example.algorithm.array.MinAbsoluteSumPair
import com.example.algorithm.array.MinimumAbsoluteDifference
import com.example.algorithm.hastable.LongestConsecutiveSequence
import com.example.algorithm.hastable.PairWithGivenSum
import com.example.algorithm.hastable.UniqueCharacterInString
import com.example.algorithm.hastable.ValidAnagram
import com.example.algorithm.stack.CheckBalanceOfParenthesis
import com.example.algorithm.stack.ReverseStackUsingRecursion
import com.example.algorithm.stack.SortAStackUsingAnotherStack
import java.util.*

class MainActivity : AppCompatActivity() {

    /**
     * Array algorithm
     */
    private val minAbsoluteSumPair by lazy { MinAbsoluteSumPair() }
    private val uniqueCharacterInString by lazy { UniqueCharacterInString() }
    private val countSubArray by lazy { CountSubArray() }
    private val minimumAbsoluteDifference by lazy { MinimumAbsoluteDifference() }
    private val reverseStack by lazy { ReverseStackUsingRecursion() }
    private val sortStackUsingAnotherStack by lazy { SortAStackUsingAnotherStack() }
    private val checkBalanceOfParenthesis by lazy { CheckBalanceOfParenthesis() }
    private val pairWithGivenSum by lazy { PairWithGivenSum() }
    private val validAnagram by lazy { ValidAnagram() }
    private val longestConsecutiveSequence by lazy { LongestConsecutiveSequence() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testLongestConsecutiveSequence()
        //testValidAnagram()
        //testPairWithGivenSum()
        //testCheckBalanceOfParenthesis()
        //testSortStartUsingAnotherStack()
        //testReverseStack()
        //testMinimumAbsoluteDifference()
        //testCountSubArray()
        //testUniqueCharacterInString()
        //testMinAbsSumPair()
    }

    private fun testLongestConsecutiveSequence() {
        println(longestConsecutiveSequence.execute(listOf(1, 9, 3, 10, 4, 20, 2)))
        println(longestConsecutiveSequence.execute(listOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)))
        println(longestConsecutiveSequence.execute(listOf(36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42)))
    }

    private fun testValidAnagram() {
        println(validAnagram.solution1("listen", "silent"))
        println(validAnagram.solution1("anagram", "nagaram"))
        println(validAnagram.solution1("rat", "car"))
    }

    private fun testPairWithGivenSum() {
        println(pairWithGivenSum.execute(listOf(1, 5, 7, -1, 5), 6))
        println(pairWithGivenSum.execute(listOf(2, 5, 17, -1), 7))
        println(pairWithGivenSum.execute(listOf(1, 5, 3, 3, 3), 6))
    }

    private fun testCheckBalanceOfParenthesis() {
        println(checkBalanceOfParenthesis.isBalance("(([](){}))"))
        println(checkBalanceOfParenthesis.isBalance("(([]({)}))"))
    }

    private fun testSortStartUsingAnotherStack() {
        val stack = Stack<Int>()
        stack.addAll(listOf(4, 3, 1, 6, 2, 5))
        val output = sortStackUsingAnotherStack.execute(stack)
        output.forEach { println(it) }
    }

    private fun testReverseStack() {
        val stack1 = Stack<Int>()
        stack1.addAll(listOf(1, 5, 3, 2, 4))
        reverseStack.execute(stack1)
        stack1.forEach { println(it) }
        val stack2 = Stack<Int>()
        stack2.addAll(listOf(5, 17, 100, 11))
        reverseStack.execute(stack2)
        stack2.forEach { println(it) }
    }

    private fun testMinimumAbsoluteDifference() {
        println(minimumAbsoluteDifference.execute(listOf(5, 3, 2, 4)))
        println(minimumAbsoluteDifference.execute(listOf(2, 4, 7, 13, 17)))
        println(minimumAbsoluteDifference.execute(listOf(1, 7, -12, 22, -8, -16, 18)))
    }

    private fun testCountSubArray() {
        println(countSubArray.execute(listOf(1, 5, 7, 8, 2, 3, 9), 6))
        println(countSubArray.execute(listOf(1, 10, 12, 4, 5, 3, 2, 7), 9))
    }

    private fun testUniqueCharacterInString() {
        println(uniqueCharacterInString.execute("afteracademy"))
    }

    private fun testMinAbsSumPair() {
        val input = listOf(1, 60, -10, 70, -80, 85)
        val result = minAbsoluteSumPair.minAbsSumPairOptimise(input)
        println(result)
    }
}