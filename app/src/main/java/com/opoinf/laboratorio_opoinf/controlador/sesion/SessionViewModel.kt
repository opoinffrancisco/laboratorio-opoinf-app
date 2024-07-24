package com.opoinf.laboratorio_opoinf.controlador.sesion

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class SessionViewModel(private val context: Context) : ViewModel() {

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn.asStateFlow()

    init {
        checkSession()
    }

    private fun checkSession() {
        viewModelScope.launch {
            val token = UserPreferences.getToken(context).first()
            _isLoggedIn.value = !token.isNullOrEmpty()
        }
    }

    fun logout() {
        viewModelScope.launch {
            UserPreferences.clearToken(context)
            _isLoggedIn.value = false
        }
    }
}