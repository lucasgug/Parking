package com.lucasgugliuzza.parking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
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
