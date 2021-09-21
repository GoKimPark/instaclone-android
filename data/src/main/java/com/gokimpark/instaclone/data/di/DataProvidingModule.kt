package com.gokimpark.instaclone.data.di

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.gokimpark.instaclone.data.repositoryimpl.ProfileRepositoryImpl
import com.gokimpark.instaclone.domain.repository.ProfileRepository
import com.gokimpark.instaclone.domain.usecase.ProfileUseCase
import com.gokimpark.instaclone.domain.usecase.ProfileUseCaseImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataProvidingModule {

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideRequestQueue(@ApplicationContext context: Context): RequestQueue = Volley.newRequestQueue(context)

    @Provides
    @Singleton
    fun provideProfileRepository(
        requestQueue: RequestQueue,
        gson: Gson
    ): ProfileRepository = ProfileRepositoryImpl(requestQueue, gson)

    @Provides
    @Singleton
    fun provideProfileUseCase(
        profileRepository: ProfileRepository
    ): ProfileUseCase = ProfileUseCaseImpl(profileRepository)

}