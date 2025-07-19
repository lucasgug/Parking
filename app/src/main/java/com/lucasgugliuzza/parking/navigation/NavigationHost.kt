package com.lucasgugliuzza.parking.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lucasgugliuzza.authentication.presentation.LoginScreen

@Composable
fun NavigationHost(
    navHostController: NavHostController,
    startDestination: NavigationRoute,
) {
    NavHost(navController = navHostController, startDestination = startDestination.route) {
        composable(NavigationRoute.LoginScreen.route) {
            LoginScreen()
        }

        composable(NavigationRoute.HomeScreen.route) {
            Text("HOME SCREEN")
        }
    }
}