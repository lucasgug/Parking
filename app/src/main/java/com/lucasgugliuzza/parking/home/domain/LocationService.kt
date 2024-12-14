package com.lucasgugliuzza.parking.home.domain


import com.lucasgugliuzza.parking.home.domain.model.Location
import kotlinx.coroutines.flow.Flow


interface LocationService {
    fun getLocationUpdates(): Flow<Location?>  //nos suscribe al servicio de Location de Android y no vas actualizando constantemente la ubicacion del usuario
    fun stopLocationUpdates()
    suspend fun getCurrentLocation(): Location?  //nos devuelve la ultima ubicacion del usuario
}