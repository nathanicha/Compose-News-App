package com.example.newsapp.di

import com.example.newsapp.data.network.getNewsApiService
import com.example.newsapp.data.network.getOkHttpClient
import com.example.newsapp.data.network.getRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) = getRetrofit(okHttpClient)

    @Provides
    @Singleton
    fun provideOkHttpClient() = getOkHttpClient()

    @Provides
    @Singleton
    fun provideNewsApiService(retrofit: Retrofit) = getNewsApiService(retrofit)
}