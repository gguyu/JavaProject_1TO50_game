package com.example.javaproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DifficultyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var homeButton : Button

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_difficulty)

        // 홈 버튼 ==> 누르면 타이틀 화면으로 다시 이동
        homeButton = findViewById(R.id.homeButton)
        homeButton.setOnClickListener {
            finish()
        }
    }
}