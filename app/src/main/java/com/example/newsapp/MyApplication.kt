package com.example.newsapp

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

    companion object {
        lateinit var coaApplication: MyApplication
        fun getContext(): Context {
            return coaApplication.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        // Initialize things here if needed
    }
}