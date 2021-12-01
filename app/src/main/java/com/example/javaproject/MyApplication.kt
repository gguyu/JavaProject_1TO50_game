package com.example.javaproject

import android.app.Application
import android.content.SharedPreferences

class MyApplication : Application() {
    companion object {
        lateinit var prefs : SharedPreferences
    }

    override fun onCreate() {
        prefs = applicationContext.getSharedPreferences("score", MODE_PRIVATE)
        super.onCreate()
    }

}