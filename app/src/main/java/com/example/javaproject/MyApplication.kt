package com.example.javaproject

import android.app.Application
import android.content.SharedPreferences

// 난이도 별 최고 점수만 저장하므로 로컬 db 보다 SharedPreferences 활용하여 저장
class MyApplication : Application() {
    companion object {
        lateinit var prefs : SharedPreferences
    }

    override fun onCreate() {
        // data 에 score 파일로 생성
        prefs = applicationContext.getSharedPreferences("score", MODE_PRIVATE)
        super.onCreate()
    }

}