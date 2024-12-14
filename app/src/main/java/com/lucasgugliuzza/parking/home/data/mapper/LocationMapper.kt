package com.lucasgugliuzza.parking.home.data.mapper

import android.location.Location


fun Location.toDomain(): com.lucasgugliuzza.parking.home.domain.model.Location {
    return com.lucasgugliuzza.parking.home.domain.model.Location(
        latitude = this.latitude,
        longitude = this.longitude
    )
}