package com.example.algorithm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.algorithm.coroutine.TestFlowWithMultipleCollectors
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

private val test = TestFlowWithMultipleCollectors()

class MainActivityViewModel : ViewModel() {

    fun test() {
        viewModelScope.launch {
            test.subscribe("Collector 1", viewModelScope).collect {
                println(it)
            }
        }
        println("===Start second collector")
        viewModelScope.launch {
            test.subscribe("Collector 2", viewModelScope).collect {
                println(it)
            }
//            listOf(
//                async {
//                    test.subsribeFlow("Collector 1", viewModelScope).collect {
//                        println(it)
//                    }
//                },
//                async {
//                    test.subsribeFlow("Collector 2", viewModelScope).collect {
//                        println(it)
//                    }
//                }
//            ).awaitAll()
        }
    }
}

class MainActivityViewModel2 : ViewModel() {

    fun test() {
//        viewModelScope.launch {
//            test.subsribeFlow("Collector 1", viewModelScope).collect {
//                println(it)
//            }
//        }
    }
}

class MainActivityViewModel3 : ViewModel() {

    fun test() {
        viewModelScope.launch {
            for (i in 0..10) {
                //test.emitFLow(i.toString(), viewModelScope)
            }
        }
    }
}