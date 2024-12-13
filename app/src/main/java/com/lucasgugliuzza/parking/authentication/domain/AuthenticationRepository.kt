package com.lucasgugliuzza.parking.authentication.domain

interface AuthenticationRepository {
    suspend fun oneTapLogin() : Result<Unit>
}

