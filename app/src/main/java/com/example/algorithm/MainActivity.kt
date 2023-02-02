package com.example.algorithm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.algorithm.array.CountSubArray
import com.example.algorithm.array.MinAbsoluteSumPair
import com.example.algorithm.hastable.UniqueCharacterInString
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    /**
     * Array algorithm
     */
    private val minAbsoluteSumPair by lazy { MinAbsoluteSumPair() }
    private val uniqueCharacterInString by lazy { UniqueCharacterInString() }
    private val countSubArray by lazy { CountSubArray() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testCountSubArray()
        //testUniqueCharacterInString()
        //testMinAbsSumPair()
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