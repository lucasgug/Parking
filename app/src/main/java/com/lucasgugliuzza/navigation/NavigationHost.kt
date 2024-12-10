package com.lucasgugliuzza.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationHost(
    navHostController: NavHostController,
    startDestination : NavigationRoute
){
    NavHost(navController = navHostController, startDestination = startDestination.route){
        composable(NavigationRoute.LoginScreen.route){
            Text(text = "Login Screen")
        }

        composable(NavigationRoute.HomeScreen.route){
            Text(text = "Home Screen")
        }

    }

}