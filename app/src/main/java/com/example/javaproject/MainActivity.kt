package com.example.javaproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var startButton : Button
    lateinit var tipButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 게임 시작 버튼 ==> 게임 화면으로 이동
        startButton = findViewById(R.id.startButton)
        startButton.setOnClickListener {
            startActivity(Intent(this, DifficultyActivity::class.java))
        }

        // 게임 방법 버튼 ==> 게임 방법 화면으로 이동
        tipButton= findViewById(R.id.tipButton)
        tipButton.setOnClickListener {
            startActivity(Intent(this, TipActivity::class.java))

        }




    }





}