package com.lucasgugliuzza.parking.ui.theme


import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat


private val DarkColorScheme = darkColorScheme(
    primary = AccentColor,
    secondary = AccentColor,
    tertiary = AccentColor
)

@Composable
fun ParkingTheme(
    content: @Composable () -> Unit
) {

//PONEMOS LOS ICONOS DE TOP BAR (BATERIA, WIFI ,ETC) EN BLANCO
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window,view).isAppearanceLightStatusBars = false
        }
    }




    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}