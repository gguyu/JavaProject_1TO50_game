package com.example.javaproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DifficultyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var easyButton : Button
        lateinit var commonButton : Button
        lateinit var hardButton : Button
        lateinit var homeButton : Button

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_difficulty)

        // 이지 버튼 ==> 누르면 쉬움 난이도로 게임 실행
        easyButton = findViewById(R.id.easyButton)
        easyButton.setOnClickListener {
            println("쉬움 모드, 난이도를 인자로 넘겨주기")
            startActivity(Intent(this, GameActivity::class.java))
        }

        // 커먼 버튼 ==> 누르면 보통 난이도로 게임 실행
        commonButton = findViewById(R.id.commonButton)
        commonButton.setOnClickListener {
            println("보통 모드, 난이도를 인자로 넘겨주기")
        }

        // 커먼 버튼 ==> 누르면 보통 난이도로 게임 실행
        hardButton = findViewById(R.id.hardButton)
        hardButton.setOnClickListener {
            println("하드 모드, 난이도를 인자로 넘겨주기")
        }

        // 홈 버튼 ==> 누르면 타이틀 화면으로 다시 이동
        homeButton = findViewById(R.id.homeButton)
        homeButton.setOnClickListener {
            finish()
        }
    }
}