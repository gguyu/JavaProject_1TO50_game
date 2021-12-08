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

        // 난이도 인자 설정 (easy: 1 , common: 2, hard: 3)
        // 이지 버튼 ==> 누르면 쉬움 난이도로 게임 실행
        easyButton = findViewById(R.id.easyButton)
        easyButton.setOnClickListener {
            // GameActivity에 인자로 1 넘겨줌 (쉬움 난이도)
            val intent = Intent(this@DifficultyActivity, GameActivity::class.java)
            intent.putExtra("difficulty", 1)
            startActivity(intent)
            finish()
        }

        // 커먼 버튼 ==> 누르면 보통 난이도로 게임 실행
        commonButton = findViewById(R.id.commonButton)
        commonButton.setOnClickListener {
            // GameActivity에 인자로 2 넘겨줌 (보통 난이도)
            val intent = Intent(this@DifficultyActivity, GameActivity::class.java)
            intent.putExtra("difficulty", 2)
            startActivity(intent)
            finish()
        }

        // 하드 버튼 ==> 누르면 보통 난이도로 게임 실행
        hardButton = findViewById(R.id.hardButton)
        hardButton.setOnClickListener {
            // GameActivity에 인자로 3 넘겨줌 (하드 난이도)
            val intent = Intent(this@DifficultyActivity, GameActivity::class.java)
            intent.putExtra("difficulty", 3)
            startActivity(intent)
            finish()
        }

        // 홈 버튼 ==> 누르면 타이틀 화면으로 다시 이동
        homeButton = findViewById(R.id.homeButton)
        homeButton.setOnClickListener {
            finish()
        }
    }
}