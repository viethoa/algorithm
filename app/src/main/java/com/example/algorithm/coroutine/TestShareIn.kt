package com.example.algorithm.coroutine

//import androidx.lifecycle.Lifecycle
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.repeatOnLifecycle
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.flow.SharingStarted
//import kotlinx.coroutines.flow.collect
//import kotlinx.coroutines.flow.collectLatest
//import kotlinx.coroutines.flow.flow
//import kotlinx.coroutines.flow.map
//import kotlinx.coroutines.flow.stateIn
//import kotlinx.coroutines.launch
//
//typealias Machines = List<Machine>
//
//data class Machine(val serial: String, val name: String)
//
//sealed interface MachineListUiState {
//    object Loading : MachineListUiState
//    data class Success(val manifest: Machines) : MachineListUiState
//
//    fun getName(): String {
//        return when (this) {
//            is Loading -> "Loading"
//            is Success -> "Success ${this.manifest.size}"
//        }
//    }
//}
//
//class TestShareIn : ViewModel() {
//
//    private val _machines = flow<Machines> {
//        println("Get machines")
//        listOf(Machine("123", "456"))
//    }
//
//    private val uiState = _machines
//        .map { MachineListUiState.Success(it) }
//        .stateIn(
//            viewModelScope,
//            SharingStarted.WhileSubscribed(5000),
//            MachineListUiState.Loading
//        )
//
//    fun execute(lifecycle: Lifecycle) {
//        viewModelScope.launch {
//            lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
//                uiState.collect {
//                    println(it.getName())
//                }
//            }
//            lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
//                uiState.collect {
//                    println(it.getName())
//                }
//            }
//        }
//    }
//}