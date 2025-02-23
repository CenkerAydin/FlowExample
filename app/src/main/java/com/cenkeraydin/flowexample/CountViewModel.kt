package com.cenkeraydin.flowexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CountViewModel : ViewModel() {
    private val _countdown = MutableStateFlow(10)
    val countdown = _countdown.asStateFlow()

    fun startCountdown() {
        viewModelScope.launch {
            for (i in 10 downTo 0) {
                _countdown.value = i
                delay(1000L)
            }
        }
    }


}