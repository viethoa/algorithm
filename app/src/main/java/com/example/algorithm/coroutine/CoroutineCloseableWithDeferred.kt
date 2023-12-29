package com.example.algorithm.coroutine

import java.io.Closeable
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class CoroutineCloseableWithDeferred : Closeable {

    private lateinit var deferred: Deferred<Int>

    suspend fun getInt(): Int {
        withContext(Dispatchers.IO) {
            deferred = async { random() }
        }
        return deferred.await()
    }

    private fun random(): Int {
        Thread.sleep(3000)
        return 10
    }

    private fun random2(): Flow<String> = flow {
        emit("TE")
    }

    override fun close() {
        if (::deferred.isInitialized) {
            deferred.cancel()
        }
    }
}