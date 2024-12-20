package com.lucasgugliuzza.parking.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lucasgugliuzza.parking.authentication.presentation.LoginScreen
import com.lucasgugliuzza.parking.home.presentation.HomeScreen

@Composable
fun NavigationHost(
    navHostController: NavHostController,
    startDestination : NavigationRoute
){
    NavHost(navController = navHostController, startDestination = startDestination.route){
        composable(NavigationRoute.LoginScreen.route){
            LoginScreen(onLoggedIn = {
                navHostController.popBackStack()
                navHostController.navigate(NavigationRoute.HomeScreen.route)
            })
        }

        composable(NavigationRoute.HomeScreen.route){
            HomeScreen()
        }

    }

}