package com.lucasgugliuzza.parking.home.presentation.components

import android.location.Location
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties

@Composable
fun HomeMap(
    currentLocation : Location?,
    carLocation : Location?,
    modifier: Modifier = Modifier
) {
    GoogleMap(
        modifier = modifier,
        properties = MapProperties(
            isMyLocationEnabled = true, //te indica la ubicacion del usuario con un punto
        )

    )


}
