package com.example.algorithm.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class TestFlowWithMultipleCollectors(private val coroutineScope: CoroutineScope) {

    private val _mySharedFlow = MutableSharedFlow<String>()
    val sharedFlow: SharedFlow<String> = _mySharedFlow

    suspend fun emitData() {
        for (i in 0..10) {
            coroutineScope.launch { _mySharedFlow.emit("$i") }
        }
    }
}