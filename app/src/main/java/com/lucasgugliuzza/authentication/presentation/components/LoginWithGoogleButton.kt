package com.lucasgugliuzza.authentication.presentation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucasgugliuzza.parking.R
import com.lucasgugliuzza.parking.ui.theme.AccentColor

@Composable
fun LoginWithGoogleButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier

) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(70.dp)) //Al clickear nos aseguramos que el fondo tenga bordes redondeados
            .background(color = AccentColor)
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_google_logo),
            contentDescription = "Google Logo",
            tint = Color.Black
        )

        Text(
            text,
            modifier = Modifier,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 16.sp
        )

        Icon(
            painter = painterResource(R.drawable.ic_google_logo),
            contentDescription = "Google Logo",
            tint = Color.Transparent
        )


    }
}

@Preview
@Composable
fun LoginWithGoogleButtonPreview() {
    LoginWithGoogleButton({}, "Continue with Google", modifier = Modifier.fillMaxWidth())
}