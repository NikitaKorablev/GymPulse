package ru.app.di

import ru.app.network.ApiService
import ru.app.repository.Repository
import ru.app.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import ru.app.BuildConfig
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun providesRetrofit(): ApiService = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(
            Json.asConverterFactory(
            "application/json; charset=UTF8".toMediaType()))
        .build()
        .create(ApiService::class.java)

    @Provides
    @Singleton
    fun providesRepository(repositoryImpl: RepositoryImpl): Repository = repositoryImpl
}