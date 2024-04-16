package com.example.algorithm.coroutine

import java.io.Closeable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutineCloseableWithDeferred : Closeable {

    private lateinit var deferred: Deferred<Int>

    fun execute() {
        CoroutineScope(Dispatchers.Main).launch {
            println("Test ${getInt()}")
            println("Test done")
        }
        CoroutineScope(Dispatchers.Main).launch {
            delay(1000)
            close()
        }
    }

    private suspend fun getInt(): Int {
        withContext(Dispatchers.IO) {
            deferred = async { random() }
        }
        return deferred.await()
    }

    private fun random(): Int {
        Thread.sleep(2000)
        return 10
    }

    override fun close() {
        println("close")
        deferred.cancel()
    }
}