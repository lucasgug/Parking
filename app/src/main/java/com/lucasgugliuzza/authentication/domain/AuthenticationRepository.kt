package com.lucasgugliuzza.authentication.domain

interface AuthenticationRepository {
    suspend fun oneTapLogin(): Result<Unit>
}