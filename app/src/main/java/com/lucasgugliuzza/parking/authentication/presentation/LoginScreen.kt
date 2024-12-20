package com.lucasgugliuzza.parking.authentication.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lucasgugliuzza.parking.R
import com.lucasgugliuzza.parking.authentication.presentation.conponents.LoginWithGoogleButton


@Composable
fun LoginScreen(
    onLoggedIn: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val context = LocalContext.current

    //cuando el estado cambia a logged in se llama al onLoggedIn()
    LaunchedEffect(state.loginStatus ) {
        if (state.loginStatus == LoginStatus.LOGGED_IN) {
            onLoggedIn()
        }
    }


    Scaffold(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .offset(y = (-80).dp),
                painter = painterResource(id = R.drawable.background),
                contentDescription = null,
            )
            LoginWithGoogleButton(
                onClick = {
                    viewModel.onEvent(LoginEvent.LogIn(context))
                },
                text = "Continue with Google",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(horizontal = 16.dp, vertical = 32.dp)
            )
        }
    }
}

