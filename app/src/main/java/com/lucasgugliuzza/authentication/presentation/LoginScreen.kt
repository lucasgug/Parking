package com.lucasgugliuzza.authentication.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lucasgugliuzza.authentication.presentation.components.LoginWithGoogleButton
import com.lucasgugliuzza.parking.R

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val context = LocalContext.current

    Scaffold(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

            Image(
                painter = painterResource(R.drawable.ic_background),
                contentDescription = "background",
                modifier = Modifier.fillMaxSize().offset(y=(-80).dp)
            )

            LoginWithGoogleButton(
                onClick = { viewModel.onEvent(LoginEvent.LogIn(context)) },
                text = "Continue with Google",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = BottomCenter)
                    .padding(horizontal = 16.dp, vertical = 32.dp)

            )

        }
    }
}