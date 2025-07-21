package com.lucasgugliuzza.authentication.data

import android.content.Context
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import com.lucasgugliuzza.parking.BuildConfig
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.firebase.Firebase
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import com.lucasgugliuzza.authentication.domain.AuthenticationRepository
import kotlinx.coroutines.tasks.await
import java.security.MessageDigest
import java.util.UUID

class FirebaseAuthenticationRepository(
    private val context: Context
) : AuthenticationRepository {
    override suspend fun oneTapLogin(): Result<Unit> {
        val credentialManager = CredentialManager.create(context)
        val nonce = UUID.randomUUID().toString().toByteArray()
        val digest = MessageDigest.getInstance("SHA-256").digest(nonce)
        val encryptedNonce = digest.joinToString("") { "%02x".format(it) }
        val googleOptions = GetGoogleIdOption.Builder()
            .setFilterByAuthorizedAccounts(false) // permite seleccionar cualquier cuenta de Google, no solo las autorizadas
            .setAutoSelectEnabled(true) //sirve se seleccionar automaticamente la cuenta
            .setNonce(encryptedNonce)
            .setServerClientId(BuildConfig.GOOGLE_WEBCLIENT_ID).build()
        val request = GetCredentialRequest.Builder().addCredentialOption(googleOptions)
        return try {
            val result = credentialManager.getCredential(context, request.build()).credential
            val googleIdToken = GoogleIdTokenCredential.createFrom(result.data).idToken
            val firebaseCredential = GoogleAuthProvider.getCredential(googleIdToken, null)

            val firebaseResult = Firebase.auth.signInWithCredential(firebaseCredential).await()
            if (firebaseResult  == null ){
                return Result.failure(Exception("Failed to sign in , please try again later"))
            }
            Result.success(Unit)
        }catch (e: Exception){
            Result.failure(e)
        }

    }
}