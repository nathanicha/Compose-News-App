package com.example.newsapp.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private val loggingInterceptor = HttpLoggingInterceptor().apply {
//        level = if (BuildConfig.DEBUG) {
    HttpLoggingInterceptor.Level.BODY
//        } else {
//            HttpLoggingInterceptor.Level.NONE
//        }
}

fun getRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
    .client(okHttpClient)
    .baseUrl("https://newsapi.org/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

fun getOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().apply {
        addNetworkInterceptor(loggingInterceptor)
        connectTimeout(35, TimeUnit.SECONDS)
        readTimeout(35, TimeUnit.SECONDS)
        writeTimeout(35, TimeUnit.SECONDS)
        retryOnConnectionFailure(true)
    }.build()
}

fun getNewsApiService(retrofit: Retrofit): NewsApiService =
    retrofit.create(NewsApiService::class.java)