package com.lucasgugliuzza.parking.authentication.presentation

import com.lucasgugliuzza.parking.navigation.NavigationRoute

data class LoginState(
    val loginStatus: LoginStatus = LoginStatus.IDLE
)

enum class LoginStatus{
    IDLE,LOADING,LOGGED_IN
}