package com.lucasgugliuzza.parking.home.data

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Looper
import androidx.core.content.ContextCompat
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.lucasgugliuzza.parking.home.data.mapper.toDomain
import com.lucasgugliuzza.parking.home.domain.LocationService
import com.lucasgugliuzza.parking.home.domain.model.Location
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class LocationServiceImpl(
    private val context: Context
) : LocationService {
    private val locationClient = LocationServices.getFusedLocationProviderClient(context)
    private var locationCallback: LocationCallback? = null

    @SuppressLint("MissingPermission")
    override fun getLocationUpdates(): Flow<Location?> {
        return callbackFlow {
            if (!hasLocationPermissions(context)) {
                trySend(null)
                close()
                return@callbackFlow
            }
            //crea una peticion de ubicacion
            val request = LocationRequest.Builder(1000)
                .setPriority(Priority.PRIORITY_HIGH_ACCURACY) //mayor precision
                .setWaitForAccurateLocation(false) //no espera a que la ubicacion sea exacta en caso de no poder hacerlo
                .setMinUpdateDistanceMeters(5f) //margen de actualizacion en este caso un  minimo de 5 mts
                .setMaxUpdateDelayMillis(1000) //tiempo entre actualizaciones
                .build()
            locationCallback = object : LocationCallback() {
                override fun onLocationResult(locationResult: LocationResult) {
                    locationResult.lastLocation?.let {
                        trySend(it.toDomain())
                    }
                }
            }
            //obtene  ubicacion del usuario
            locationClient.requestLocationUpdates(
                request,
                locationCallback!!,
                Looper.getMainLooper()
            )
        }
    }
    //verifica si el usuario tiene los permisos de ubicacion
    private fun hasLocationPermissions(context: Context): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }


    override fun stopLocationUpdates() {
        locationCallback?.let {
            locationClient.removeLocationUpdates(it)
        }
    }

    @SuppressLint("MissingPermission")
    override suspend fun getCurrentLocation(): Location? {
        if (!hasLocationPermissions(context)) {
            return null
        }
        val result = locationClient.getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, null).await()
        return result.toDomain()
    }
}