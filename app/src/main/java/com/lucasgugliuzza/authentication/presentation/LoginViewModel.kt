package com.lucasgugliuzza.authentication.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucasgugliuzza.authentication.domain.AuthenticationRepository
import kotlinx.coroutines.launch
import javax.inject.Inject


@dagger.hilt.android.lifecycle.HiltViewModel
class LoginViewModel @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) : ViewModel() {
    var state by mutableStateOf(LoginState())
        private set

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.LogIn -> {
              viewModelScope.launch {
                  authenticationRepository.oneTapLogin()
              }
            }
        }
    }
}