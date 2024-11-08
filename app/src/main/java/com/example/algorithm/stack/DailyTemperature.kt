package com.example.algorithm.stack

import java.util.*

/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait
 * after the ith day to get a warmer temperature. If there is no future day
 * for which this is possible, keep answer[i] == 0 instead.
 *
 * Example 1:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Explanation:
 * - 73 -> 74 = 1day, ....
 * - 75 -> 76 = 4days
 *
 * Example 2:
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 *
 * Example 3:
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 *
 * [Medium] https://leetcode.com/problems/daily-temperatures/description/
 */
class DailyTemperature {


    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    /**
     * Dry run
     * Input: [73,74,75,71,69,72,76,73]
     *  - Step0: stack [0], result []
     *  - Step1: stack [1], result[1]
     *  - Step2: stack [2], result[1,1]
     *  - Step3: stack [2,3], result[1,1]
     *  - Step4: stack [2,3,4], result[1,1]
     *  - Step5: stack [2,5], result[1,1,_,2,1,_,_,_]
     *  - Step6: stack [6], result[1,1,4,2,1,1,_,_]
     *  - Step7: stack [6,7], result[1,1,4,2,1,1,_,_]
     */
    private fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size)
        val stack = Stack<Int>()

        temperatures.forEachIndexed { i, element ->
            while (!stack.isEmpty() && temperatures[stack.peek()] < element) {
                result[stack.peek()] = i - stack.peek()
                stack.pop()
            }

            stack.push(i)
        }

        return result
    }
}




















