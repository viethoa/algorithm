package com.example.algorithm.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class TestFlowWithMultipleCollectors {

    private val myFlow = MutableSharedFlow<String>()

    suspend fun subscribe(name: String, coroutineScope: CoroutineScope): Flow<String> = flow {
        for (i in 0..10) {
            emit("$name: $i")
        }
    }

    fun subsribeFlow(name: String, coroutineScope: CoroutineScope): Flow<String> = myFlow

    suspend fun emitFLow(data: String, coroutineScope: CoroutineScope) {
        coroutineScope.launch {
            myFlow.emit(data)
        }
    }

}