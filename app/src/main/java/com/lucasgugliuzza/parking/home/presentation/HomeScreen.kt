package com.lucasgugliuzza.parking.home.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Directions
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lucasgugliuzza.parking.home.presentation.components.HomeButton
import com.lucasgugliuzza.parking.home.presentation.components.HomeMap
import com.lucasgugliuzza.parking.home.presentation.components.HomeSearch


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state = viewModel.state
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            HomeMap(
                currentLocation = state.currentLocation,
                carLocation = null,
                modifier = Modifier.fillMaxSize()
            )
            when (state.carStatus) {
                CarStatus.NO_PARKED_CAR -> {
                    HomeButton(
                        onClick = { viewModel.onEvent(HomeEvent.SaveCar) },
                        text = "Park Here",
                        imageVector = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 64.dp)
                            .padding(horizontal = 16.dp)
                    )
                }
                CarStatus.PARKED_CAR -> {
                    HomeButton(
                        onClick = { viewModel.onEvent(HomeEvent.StartSearch) },
                        text = "Get Directions",
                        imageVector = Icons.Default.Directions,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 64.dp)
                            .padding(horizontal = 16.dp)
                    )
                }
                CarStatus.SEARCHING -> {
                    HomeSearch(
                        distance = "1.3km", onClick = {
                            viewModel.onEvent(HomeEvent.StopSearch)
                        }, modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 64.dp)
                            .padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }
}