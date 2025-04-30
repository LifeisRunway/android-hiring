package com.example.myapplication.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.network.SocketManager
import com.example.myapplication.network.TestRequest
import com.example.myapplication.network.TestResponse
import com.example.myapplication.utils.AppConstants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GenderAgeViewModel : ViewModel() {

    private val socketManager = SocketManager(AppConstants.SERVER_ADDRESS, AppConstants.SERVER_PORT)

    val ages = (16..30).toList().toTypedArray()

    val username = mutableStateOf<String?>(null)
    val isMaleState = MutableStateFlow<Boolean?>(null)
    val selectedAge = MutableStateFlow<Int?>(null)

    val onSuccess = MutableStateFlow<Boolean?>(null)

    fun send() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    socketManager.connect()

                    val request = TestRequest(
                        gender = if(isMaleState.value == true) "m" else "f",
                        age = selectedAge.value ?: 0
                    )
                    socketManager.send(request)

                    val response : TestResponse = socketManager.receive()

                    onSuccess.emit(response.allowed)
                } catch (e: Exception) {
                    Log.e("SocketManager", "Ошибка сокета: ${e.message}")
                } finally {
                    socketManager.close()
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        socketManager.close()
    }
}