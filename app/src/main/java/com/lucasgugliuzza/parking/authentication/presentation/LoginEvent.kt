package com.lucasgugliuzza.parking.authentication.presentation

import android.content.Context

sealed interface LoginEvent {
    data class LogIn(val context :Context) : LoginEvent

}