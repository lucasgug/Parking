package com.lucasgugliuzza.parking.navigation

sealed class NavigationRoute(val route: String) {
    data object LoginScreen : NavigationRoute("LoginScreen")
    data object HomeScreen : NavigationRoute("HomeScreen")
}