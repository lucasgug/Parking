package com.lucasgugliuzza.parking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.lucasgugliuzza.parking.navigation.NavigationHost
import com.lucasgugliuzza.parking.navigation.NavigationRoute
import com.lucasgugliuzza.parking.ui.theme.ParkingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewmodel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ParkingTheme {
                val navHostController = rememberNavController()
                val startDestination = getStartDestination()
                NavigationHost(
                    navHostController = navHostController,
                    startDestination = startDestination
                )

            }
        }
    }

    private fun getStartDestination(): NavigationRoute {
        return if (viewmodel.isLoggedIn) NavigationRoute.HomeScreen else NavigationRoute.LoginScreen
    }
}
