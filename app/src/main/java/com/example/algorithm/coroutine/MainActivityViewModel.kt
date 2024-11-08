package com.example.algorithm.coroutine

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    private val test = TestFlowWithMultipleCollectors(viewModelScope)

    fun test() {
        viewModelScope.launch {
            test.sharedFlow.collect {
                println("Collector 1 $it")
            }
        }
        println("===Start second collector")
        viewModelScope.launch {
            test.sharedFlow.collect {
                println("Collector 2 $it")
            }
        }
        viewModelScope.launch {
            test.emitData()
        }
    }
}