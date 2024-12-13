package com.lucasgugliuzza.parking

import androidx.lifecycle.ViewModel
import com.lucasgugliuzza.parking.authentication.data.FirebaseAuthenticationRepository
import com.lucasgugliuzza.parking.authentication.domain.AuthenticationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val authenticationRepository: AuthenticationRepository) :
    ViewModel() {
    val isLoggedIn = authenticationRepository.isLoggedIn()
}