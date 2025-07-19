package com.lucasgugliuzza.parking.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationHost(
    navHostController: NavHostController,
    startDestination: NavigationRoute,
) {
    NavHost(navController = navHostController, startDestination = startDestination.route) {
        composable(NavigationRoute.LoginScreen.route) {
            Text("LOGIN SCREEN")
        }

        composable(NavigationRoute.HomeScreen.route) {
            Text("HOME SCREEN")
        }
    }
}