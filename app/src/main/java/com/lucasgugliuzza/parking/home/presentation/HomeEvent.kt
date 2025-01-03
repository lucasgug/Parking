package com.lucasgugliuzza.parking.home.presentation

sealed interface HomeEvent {
    data object SaveCar : HomeEvent
    data object StartSearch : HomeEvent
    data object StopSearch : HomeEvent
}