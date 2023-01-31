package com.example.algorithm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.algorithm.array.MinAbsoluteSumPair
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private val minAbsoluteSumPair by lazy { MinAbsoluteSumPair() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testMinAbsSumPair()
    }

    private fun testMinAbsSumPair() {
        val input = listOf(1, 60, -10, 70, -80, 85)
        val result = minAbsoluteSumPair.minAbsSumPairOptimise(input)
        println(result)
    }
}