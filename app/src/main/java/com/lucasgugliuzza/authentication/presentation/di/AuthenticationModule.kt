package com.lucasgugliuzza.authentication.presentation.di

import android.content.Context
import com.lucasgugliuzza.authentication.data.FirebaseAuthenticationRepository
import com.lucasgugliuzza.authentication.domain.AuthenticationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthenticationModule {

    @Provides
    @Singleton
    fun provideAuthenticationRepository (@ApplicationContext context: Context): AuthenticationRepository  {
    return FirebaseAuthenticationRepository(context = context)
    }

}